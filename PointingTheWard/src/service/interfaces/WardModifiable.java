package service.interfaces;

import model.beans.Ward;

public interface WardModifiable {
	public boolean modifyWard(Ward ward, Ward newWard);
}
