package persistance.dao;

import persistance.dao.Interfaces.EventDeleteDAO;
import persistance.dao.Interfaces.EventModifyDAO;
import persistance.dao.Interfaces.EventRegistDAO;
import persistance.dao.Interfaces.EventSearchDAO;

public interface EventDAO extends EventDeleteDAO,EventModifyDAO,EventSearchDAO,EventRegistDAO{

}
