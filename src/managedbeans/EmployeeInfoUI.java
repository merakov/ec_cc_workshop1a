package managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclnt.ccee.db.dofw.DOFWSql;
import org.eclnt.ccee.util.StringUtil;
import org.eclnt.editor.annotations.CCGenClass;
import org.eclnt.jsfserver.defaultscreens.*;
import org.eclnt.jsfserver.elements.impl.FIXGRIDItem;
import org.eclnt.jsfserver.elements.impl.FIXGRIDListBinding;
import org.eclnt.jsfserver.pagebean.PageBean;
import pojos.DOCompany;
import pojos.DOEmployee;

@CCGenClass (expressionBase="#{d.EmployeeInfoUI}")

public class EmployeeInfoUI
    extends PageBean 
    implements Serializable
{


    int m_idDetail;
    public int getIdDetail() { return m_idDetail; }
    public void setIdDetail(int value) { this.m_idDetail = value; }

    String m_ibanDetail;
    public String getIbanDetail() { return m_ibanDetail; }
    public void setIbanDetail(String value) { this.m_ibanDetail = value; }

    BigDecimal m_salaryDetail;
    public BigDecimal getSalaryDetail() { return m_salaryDetail; }
    public void setSalaryDetail(BigDecimal value) { this.m_salaryDetail = value; }

    Date m_dateStartDetail;
    public Date getDateStartDetail() { return m_dateStartDetail; }
    public void setDateStartDetail(Date value) { this.m_dateStartDetail = value; }

    int m_companyIdDetail;
    public int getCompanyIdDetail() { return m_companyIdDetail; }
    public void setCompanyIdDetail(int value) { this.m_companyIdDetail = value; }

    String m_companyNameDetail;
    public String getCompanyNameDetail() { return m_companyNameDetail; }
    public void setCompanyNameDetail(String value) { this.m_companyNameDetail = value; }

    Integer m_ageDetail;
    public Integer getAgeDetail() { return m_ageDetail; }
    public void setAgeDetail(Integer value) { this.m_ageDetail = value; }

    String m_thirdNameDetail;
    public String getThirdNameDetail() { return m_thirdNameDetail; }
    public void setThirdNameDetail(String value) { this.m_thirdNameDetail = value; }

    String m_secondNameDetail;
    public String getSecondNameDetail() { return m_secondNameDetail; }
    public void setSecondNameDetail(String value) { this.m_secondNameDetail = value; }

    String m_firstNameDetail;
    public String getFirstNameDetail() { return m_firstNameDetail; }
    public void setFirstNameDetail(String value) { this.m_firstNameDetail = value; }

    Map<Integer, String> companyMap;
    public Map<Integer, String> getCompanyMap() { return companyMap; }
    public void setCompanyMap(Map<Integer, String> companyMap) { this.companyMap = companyMap; }

    IdTextSelection idts;
    public IdTextSelection getIdts() { return idts; }
    public void setIdts(IdTextSelection idts) { this.idts = idts; }



    //===============


    public class EmployeeRow extends FIXGRIDItem {

        String m_thirdName;
        public String getThirdName() { return m_thirdName; }
        public void setThirdName(String value) { this.m_thirdName = value; }

        String m_secondName;
        public String getSecondName() { return m_secondName; }
        public void setSecondName(String value) { this.m_secondName = value; }

        String m_firstName;
        public String getFirstName() { return m_firstName; }
        public void setFirstName(String value) { this.m_firstName = value; }

        int m_id;
        public int getId() { return m_id; }
        public void setId(int value) { this.m_id = value; }

        int m_age;
        public int getAge() { return m_age; }
        public void setAge(int value) { this.m_age = value; }

        int m_companyId;
        public int getCompanyId() { return m_companyId; }
        public void setCompanyId(int value) { this.m_companyId = value; }

        String m_companyName;
        public String getCompanyName() { return m_companyName; }
        public void setCompanyName(String value) { this.m_companyName = value; }

        Date m_dateStart;
        public Date getDateStart() { return m_dateStart; }
        public void setDateStart(Date value) { this.m_dateStart = value; }

        BigDecimal m_salary;
        public BigDecimal getSalary() { return m_salary; }
        public void setSalary(BigDecimal value) { this.m_salary = value; }

        String m_iban;
        public String getIban() { return m_iban; }
        public void setIban(String value) { this.m_iban = value; }


        public void onRowExecute()
        {
//            OKPopup.createInstance("Mess", this.getFirstName() + " " + this.getSecondName() + " " + this.getThirdName());

            setIdDetail(this.getId());
            setFirstNameDetail(this.getFirstName());
            setSecondNameDetail(this.getSecondName());
            setThirdNameDetail(this.getThirdName());
            setAgeDetail(this.getAge());
            setCompanyIdDetail(this.m_companyId);
            setCompanyNameDetail(this.getCompanyName());
            setDateStartDetail(this.getDateStart());
            setSalaryDetail(this.getSalary());
            setIbanDetail(this.getIban());

            selectedRow = this;
        }
    }


    FIXGRIDListBinding<EmployeeRow> m_sheet = new FIXGRIDListBinding<EmployeeRow>();
    public FIXGRIDListBinding<EmployeeRow> getSheet() { return m_sheet; }


    private EmployeeRow selectedRow;
    public EmployeeRow getSelectedRow() { return selectedRow; }
    public void setSelectedRow(EmployeeRow selectedRow) { this.selectedRow = selectedRow; }


    //====

    public void onEmployeeNew(javax.faces.event.ActionEvent event)
    {
        initDetails();
    }

    public void onEmployeeDelete(javax.faces.event.ActionEvent event)
    {


        if (selectedRow == null)
        {
            OKPopup.createInstance("Message", "No employee selected!" );
            return;
        }


        YESNOPopup.createInstance
        ("Confirm", "Delete employee?",
            new YESNOPopup.IYesNoListener() {

            @Override
            public void reactOnYes() {

                DOFWSql.delete
                        (
                            DOEmployee.class,

                            new Object[]
                                    {
                                            "id", selectedRow.m_id
                                    }
                        );

                m_sheet.getItems().remove(selectedRow);

                initDetails();
            }

            @Override
            public void reactOnNo() {
                return;
            }
        });



    }


    public void onEmployeeSave(javax.faces.event.ActionEvent event)
    {

        if (StringUtil.isEmpty(getFirstNameDetail())
            || StringUtil.isEmpty(getSecondNameDetail())
            || StringUtil.isEmpty(getThirdNameDetail())
            || getAgeDetail() == null
            || getCompanyNameDetail() == null
            || getSalaryDetail() == null
            || getDateStartDetail() == null
            || StringUtil.isEmpty(getIbanDetail())
            )
        {
            OKPopup.createInstance("Message", "Please, enter all the fields!");
            return;
        }

        DOEmployee emp = new DOEmployee();

        if (getIdDetail() != 0)
            emp.setId(getIdDetail());


        emp.setFirst_name(getFirstNameDetail());
        emp.setSecond_name(getSecondNameDetail());
        emp.setThird_name(getThirdNameDetail());
        emp.setAge(getAgeDetail());
        emp.setCompany_id(getCompanyIdDetail());
        emp.setDate_start(getDateStartDetail());
        emp.setSalary(new BigDecimal(String.valueOf((getSalaryDetail()))));
        emp.setIban(getIbanDetail());
        DOFWSql.saveObject(emp);


        if (getIdDetail() != 0)
        {
            selectedRow.setFirstName(getFirstNameDetail());
            selectedRow.setSecondName(getSecondNameDetail());
            selectedRow.setThirdName(getThirdNameDetail());
            selectedRow.setAge(getAgeDetail());
            selectedRow.setCompanyId(getCompanyIdDetail());
            selectedRow.setCompanyName(getCompanyNameDetail());
            selectedRow.setDateStart(getDateStartDetail());
            selectedRow.setSalary(getSalaryDetail());
            selectedRow.setIban(getIbanDetail());
        }
        else
        {


            DOEmployee lastAddedEmp = DOFWSql.queryOne
            (
                    DOEmployee.class,
                    new Object[]
                            {},

                    new Object[]
                            {
                                    "id"
                            }
            );


            EmployeeRow er = new EmployeeRow();

            er.m_id = lastAddedEmp.getId();
            er.m_firstName = getFirstNameDetail();
            er.m_secondName = getSecondNameDetail();
            er.m_thirdName = getThirdNameDetail();
            er.m_age = getAgeDetail();
            er.m_companyId = getCompanyIdDetail();
            er.m_companyName = getCompanyNameDetail();
            er.m_salary = getSalaryDetail();
            er.m_iban = getIbanDetail();
            er.m_dateStart = getDateStartDetail();
            m_sheet.getItems().add(er);
        }



        initDetails();



    }

    void initDetails()
    {
        setIdDetail(0);
        setFirstNameDetail(null);
        setSecondNameDetail(null);
        setThirdNameDetail(null);
        setAgeDetail(0);
        setCompanyIdDetail(0);
        setCompanyNameDetail("");
        setDateStartDetail(null);
        setSalaryDetail(null);
        setIbanDetail(null);

        selectedRow = null;
    }


    public void onCompanyEdit(javax.faces.event.ActionEvent event)
    {
        final CompanyInfoUI cui = new CompanyInfoUI();

        openModalPopup(cui,"Companies",800,600,
                new ModalPopup.IModalPopupListener()
                {
                    @Override
                    public void reactOnPopupClosedByUser()
                    {
                        closePopup(cui);

                        companyMap = new HashMap<Integer, String>();


                        CompanyInfoUI.CompanyRow cr;

                        List<DOCompany> companyList = DOFWSql.query
                        (
                                DOCompany.class,
                                new Object[]
                                        {}
                        );


                        for (DOCompany doc : companyList)
                        {
                            companyMap.put(doc.getId(), doc.getName());
                            //dummy comment
                        }

                        //================

                        for (EmployeeRow er : m_sheet.getRows())
                        {
                            er.setCompanyName(companyMap.get(er.getCompanyId()));
                        }

                        

                       setCompanyNameDetail(companyMap.get(getCompanyIdDetail()));

                    }
                });
    }

    public void onCompanyAction(javax.faces.event.ActionEvent event)
    {

        List<DOCompany> companyList = DOFWSql.query
                (
                        DOCompany.class,
                        new Object[] {},
                        new Object[] {"id"}
                );


        idts = IdTextSelection.createInstance();

        for (DOCompany doc : companyList)
        {
            idts.addLine(String.valueOf(doc.getId()), doc.getName());
        }

        idts.setCallBack(new ISetIdText()
        {
            public void setIdText(String id, String text)
            {
                m_companyIdDetail = Integer.parseInt(id);
                m_companyNameDetail = text;
            }
        });

        idts.preselect(String.valueOf(m_companyIdDetail));
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

    public EmployeeInfoUI()
    {

        selectedRow = null;

        companyMap = new HashMap<Integer, String>();


        CompanyInfoUI.CompanyRow cr;

        List<DOCompany> companyList = DOFWSql.query
        (
                DOCompany.class,
                new Object[]
                        {}
        );


        for (DOCompany doc : companyList)
        {
            companyMap.put(doc.getId(), doc.getName());
//            idts.addLine(String.valueOf(doc.getId()), doc.getName());
        }

        //=====

        EmployeeRow er;

        List<DOEmployee> employeeList = DOFWSql.query
        (
                DOEmployee.class,
                new Object[]
                {
//                  "first_name", "Ã?â€”Ã?Â»Ã?Â°Ã‘â€šÃ?Â°Ã?Â½"
                },

                new Object[]
                {
                        "first_name",
                        "second_name",
                        "third_name",
                        "age"
                }
        );


        //================

        for (DOEmployee doe : employeeList)
        {
            er = new EmployeeRow();

            er.m_id = doe.getId();
            er.m_firstName = doe.getFirst_name();
            er.m_secondName = doe.getSecond_name();
            er.m_thirdName = doe.getThird_name();
            er.m_age = doe.getAge();
            er.m_companyId = doe.getCompany_id();
            er.m_companyName = companyMap.get(doe.getCompany_id());
            er.m_salary = doe.getSalary();
            er.m_iban = doe.getIban();
            er.m_dateStart = doe.getDate_start();

            m_sheet.getItems().add(er);
        }



    }

    public String getPageName() { return "/EmployeeInfo.jsp"; }
    public String getRootExpressionUsedInPage() { return "#{d.EmployeeInfoUI}"; }

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
