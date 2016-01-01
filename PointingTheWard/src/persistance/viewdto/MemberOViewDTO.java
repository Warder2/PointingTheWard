package persistance.viewdto;

public class MemberOViewDTO {
	
		private String email;
		private String name;
		private String location;
		private String transportation;
		
		
		public MemberOViewDTO(){
			
		}


		public MemberOViewDTO(String email, String name, String location, String transportation) {
			super();
			this.email = email;
			this.name = name;
			this.location = location;
			this.transportation = transportation;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public String getTransportation() {
			return transportation;
		}


		public void setTransportation(String transportation) {
			this.transportation = transportation;
		}


		@Override
		public String toString() {
			return "MemberOViewDTO [email=" + email + ", name=" + name + ", location=" + location + ", transportation="
					+ transportation + "]";
		}
		
		
}
