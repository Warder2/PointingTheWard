package service;

import java.util.List;

public class ServiceMacro implements Service{
	private List<Service> services;
	
	public ServiceMacro() {
	}
	
	public ServiceMacro(List<Service> services) {
		this.services = services;
	}
	
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public List<Service> getServices() {
		return services;
	}

	@Override
	public String toString() {
		return "ServiceMacro [services=" + services + "]";
	}

	@Override
	public void execute(ServiceRequest request) {
		for(Service service : services){
			service.execute(request);
		}
	}
	
}
