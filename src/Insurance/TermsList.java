package Insurance;

import java.util.ArrayList;

public interface TermsList {

	public TermsListImpl m_TermsListImpl();

	public boolean add();

	public boolean delete();

	public ArrayList<Terms> retrieve();

	public boolean update();

}