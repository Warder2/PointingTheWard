package persistance.dto;

import model.beans.Transportation;

public class MemberODTO {
	
		private String email;
		private String name;
		private String location;
		private Transportation transportation;
		
		
		public MemberODTO(){
			
		}


		public MemberODTO(String email, String name, String location, Transportation transportation) {
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


		public Transportation getTransportation() {
			return transportation;
		}


		public void setTransportation(Transportation transportation) {
			this.transportation = transportation;
		}


		@Override
		public String toString() {
			return "MemberOViewDTO [email=" + email + ", name=" + name + ", location=" + location + ", transportation="
					+ transportation + "]";
		}
		
		
}
