package command;

import java.util.List;

public class WardRecommendRequest {

	
		private String title;
		private String content;
		private String scope;
		private String period;
		private String runTime;
		private List<String> particiant;
		public WardRecommendRequest() {
			super();
		}
		public WardRecommendRequest(String title, String content, String scope, String period, String runTime,
				List<String> particiant) {
			super();
			this.title = title;
			this.content = content;
			this.scope = scope;
			this.period = period;
			this.runTime = runTime;
			this.particiant = particiant;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getScope() {
			return scope;
		}
		public void setScope(String scope) {
			this.scope = scope;
		}
		public String getPeriod() {
			return period;
		}
		public void setPeriod(String period) {
			this.period = period;
		}
		public String getRunTime() {
			return runTime;
		}
		public void setRunTime(String runTime) {
			this.runTime = runTime;
		}
		public List<String> getParticiant() {
			return particiant;
		}
		public void setParticiant(List<String> particiant) {
			this.particiant = particiant;
		}
		@Override
		public String toString() {
			return "WardRecommendRequest [title=" + title + ", content=" + content + ", scope=" + scope + ", period="
					+ period + ", runTime=" + runTime + ", particiant=" + particiant + "]";
		}
		
}
