package persistance.viewdto;

public class MemberPViewDTO {

			
		private String emial;
		private String pwd;
		private String name;
		
		public MemberPViewDTO(){
			
		}

		public MemberPViewDTO(String emial, String pwd, String name) {
			super();
			this.emial = emial;
			this.pwd = pwd;
			this.name = name;
		}

		public String getEmial() {
			return emial;
		}

		public void setEmial(String emial) {
			this.emial = emial;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "MemberPViewDTO [emial=" + emial + ", pwd=" + pwd + ", name=" + name + "]";
		}
		
}
