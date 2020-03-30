package managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclnt.ccee.config.Config;
import org.eclnt.ccee.db.IDBConnectionProvider;
import org.eclnt.ccee.db.dofw.DOFWSql;
import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.elements.impl.FIXGRIDItem;
import org.eclnt.jsfserver.elements.impl.FIXGRIDListBinding;
import org.eclnt.jsfserver.pagebean.PageBean;
import org.eclnt.workplace.IWorkpageDispatcher;
import pojos.DOCompany;

import javax.faces.event.ActionEvent;

@CCGenClass (expressionBase="#{d.CompanyInfoUI}")

public class CompanyInfoUI
    extends PageBean
    implements Serializable
{



    public class CompanyRow extends FIXGRIDItem implements java.io.Serializable
    {

        private DOCompany company;

        CompanyRow(DOCompany company) {
            this.company = company;
        }


        public DOCompany getCompany() {
            return company;
        }

        @Override
        public void onRowExecute()
        {
            selectCompanyRow(this);
        }

    }


    FIXGRIDListBinding<CompanyRow> m_sheet = new FIXGRIDListBinding<CompanyRow>();
    public FIXGRIDListBinding<CompanyRow> getSheet() { return m_sheet; }


    public CompanyRow m_selCompanyRow;
    public CompanyRow getSelCompanyRow() {
        return m_selCompanyRow;
    }


    public void selectCompanyRow(CompanyRow companyRow) {
        if (m_selCompanyRow != null) m_selCompanyRow.getChangeIndex().indicateChange();
        m_selCompanyRow = companyRow;
        m_selCompanyRow.getChangeIndex().indicateChange();
    }
    

    // ------------------------------------------------------------------------
    // inner classes
    // ------------------------------------------------------------------------
    
    /* Listener to the user of the page bean. */
    public interface IListener
    {
    }
    
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    
    private IListener m_listener;
    
    // ------------------------------------------------------------------------
    // constructors & initialization
    // ------------------------------------------------------------------------

    public CompanyInfoUI()
    {
        CompanyRow r;

        List<DOCompany> companyList = DOFWSql.query
        (
                DOCompany.class,
                new Object[]
                        {},

                new Object[]
                        {
                                "id"
                        }
        );


        for (DOCompany doc : companyList)
        {
            CompanyRow row = new CompanyRow(doc);
            m_sheet.getItems().add(row);
        }

    }


    public void onCompanySave(javax.faces.event.ActionEvent event)
    {



        if (m_sheet.getSelectedItem() != null)
        {
            CompanyRow row = m_sheet.getSelectedItem();

            DOFWSql.saveObject(row.getCompany());
        }



    }


    public String getPageName() { return "/CompanyInfo.jsp"; }
    public String getRootExpressionUsedInPage() { return "#{d.CompanyInfoUI}"; }

    // ------------------------------------------------------------------------
    // public usage
    // ------------------------------------------------------------------------

    /* Initialization of the bean. Add any parameter that is required within your scenario. */
    public void prepare(IListener listener)
    {
        m_listener = listener;
    }

    // ------------------------------------------------------------------------
    // private usage
    // ------------------------------------------------------------------------
}
