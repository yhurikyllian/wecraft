package id.wecraft.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

public class Company implements Parcelable{
	
	private String name;
	private String address;
	private String city;
	private String description;
	private String tag;
	private String logo;
	private int rating;
	private Contacts contact;
	private List<Products> product;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Contacts getContact() {
		return contact;
	}
	
	public void setContact(Contacts contact) {
		this.contact = contact;
	}
	
	public List<Products> getProduct() {
		return product;
	}
	
	public void setProduct(List<Products> product) {
		this.product = product;
	}

	/*@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		arg0.writeString(name);
		arg0.writeString(address);
		arg0.writeString(city);
		arg0.writeString(description);
		arg0.writeString(tag);
		arg0.writeString(logo);
		arg0.writeInt(rating);
		//arg0.writeList(contact);
		arg0.writeList(product);
		arg0.writeTypedList(contact);
	}
	
	public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {

		@Override
		public Company createFromParcel(Parcel arg0) {
			// TODO Auto-generated method stub
			return new Company(arg0);
		}

		@Override
		public Company[] newArray(int arg0) {
			// TODO Auto-generated method stub
			return new Company[arg0];
		}
	
	};
	
	private Company(Parcel in) {
		name = in.readString();
		address = in.readString();
		city = in.readString();
		description = in.readString();
		tag = in.readString();
		logo = in.readString();
		rating = in.readInt();
		product = new ArrayList<Company.products>();
		//kalo error ganti "null" jadi products.CREATOR
		//dan readList jadi readTypedList
		in.readList(product, null);
		contact = new ArrayList<Company.contacts>();
		in.readList(contact, null);
	}*/
	
	protected Company(Parcel in) {
        name = in.readString();
        address = in.readString();
        city = in.readString();
        description = in.readString();
        tag = in.readString();
        logo = in.readString();
        rating = in.readInt();
        /*if (in.readByte() == 0x01) {
            contact = new ArrayList<contacts>();
            in.readList(contact, contacts.class.getClassLoader());
        } else {
            contact = null;
        }
        if (in.readByte() == 0x01) {
            product = new ArrayList<products>();
            in.readList(product, products.class.getClassLoader());
        } else {
            product = null;
        }*/
        contact = new Contacts();
        contact = in.readParcelable(Contacts.class.getClassLoader());
        //contact = new ArrayList<contacts>();
        product = new ArrayList<Products>();
        //in.readList(contact, contacts.class.getClassLoader());
        in.readList(product, Products.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(city);
        dest.writeString(description);
        dest.writeString(tag);
        dest.writeString(logo);
        dest.writeInt(rating);
        /*if (contact == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(contact);
        }
        if (product == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(product);
        }*/
        //dest.writeList(contact);
        dest.writeParcelable(contact, flags);
        dest.writeList(product);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
    
    public static class Contacts implements Parcelable{
		public String hp;
		public String bbm;
		
		public Contacts(){}
		
		protected Contacts(Parcel in) {
			hp = in.readString();
	        bbm = in.readString();
	    }
		
		public String getHp() {
			return hp;
		}
		public void setHp(String hp) {
			this.hp = hp;
		}
		public String getBbm() {
			return bbm;
		}
		public void setBbm(String bbm) {
			this.bbm = bbm;
		}

	    @Override
	    public int describeContents() {
	        return 0;
	    }

	    @Override
	    public void writeToParcel(Parcel dest, int flags) {
	    	 dest.writeString(hp);
	         dest.writeString(bbm);
	    }

	    @SuppressWarnings("unused")
	    public static final Parcelable.Creator<Contacts> CREATOR = new Parcelable.Creator<Contacts>() {
	        @Override
	        public Contacts createFromParcel(Parcel in) {
	            return new Contacts(in);
	        }

	        @Override
	        public Contacts[] newArray(int size) {
	            return new Contacts[size];
	        }
	    };
	}
	
	public static class Products implements Parcelable{
		public String pName;
		public String pImage;
		
		protected Products(Parcel in) {
			pName = in.readString();
	        pImage = in.readString();
		}
		
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public String getpImage() {
			return pImage;
		}
		public void setpImage(String pImage) {
			this.pImage = pImage;
		}
		
		@Override
		public int describeContents() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void writeToParcel(Parcel arg0, int arg1) {
			// TODO Auto-generated method stub
			arg0.writeString(pName);
			arg0.writeString(pImage);
		}
		
		@SuppressWarnings("unused")
	    public static final Parcelable.Creator<Products> CREATOR = new Parcelable.Creator<Products>() {
	        @Override
	        public Products createFromParcel(Parcel in) {
	            return new Products(in);
	        }

	        @Override
	        public Products[] newArray(int size) {
	            return new Products[size];
	        }
	    };
	}
}
