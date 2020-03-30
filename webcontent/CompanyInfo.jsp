<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@taglib prefix="t" uri="/WEB-INF/eclnt"%>


<!-- ========== CONTENT BEGIN ========== -->
<f:view>
<h:form>
<f:subview id="CompanyInfog_sv">
<t:beanprocessing id="g_1" />
<t:rowtitlebar id="g_2" text="Фирми" />
<t:rowheader id="g_3" />
<t:rowbodypane id="g_4" >
<t:row id="g_5" >
<t:fixgrid id="g_6" drawoddevenbackgroundeven="#d9e2f3" drawoddevenbackgroundodd="#bdd7ee" drawoddevenrows="true" objectbinding="#{d.CompanyInfoUI.sheet}" sbvisibleamount="5" stylevariant="WP_FUNCTIONTREE_BIG" width="100%" >
<t:gridcol id="g_7" stylevariant="IDVALUESELECTION" width="20" >
<t:gridrowselector id="g_8" background="#aeabab" />
</t:gridcol>
<t:gridcol id="g_9" text="Id" width="30" >
<t:field id="g_10" text=".{company.id}" />
</t:gridcol>
<t:gridcol id="g_11" text="Наименование" width="300" >
<t:field id="g_12" text=".{company.name}" />
</t:gridcol>
<t:gridcol id="g_13" text="Дата на основаване" width="150" >
<t:label id="g_14" format="date" text=".{company.date_established}" />
</t:gridcol>
<t:gridcol id="g_15" text="Булстат" width="150" >
<t:field id="g_16" text=".{company.bulstat}" />
</t:gridcol>
</t:fixgrid>
</t:row>
<t:rowdistance id="g_17" height="30" />
<t:rowtitlebar id="g_18" text="Детайли" />
<t:row id="g_19" coldistance="5" >
<t:pane id="g_20" rowdistance="5" >
<t:row id="g_21" />
<t:rowdistance id="g_22" height="10" />
<t:row id="g_23" >
<t:label id="g_24" text="Наименование" width="150" />
<t:field id="g_25" text="#{d.CompanyInfoUI.selCompanyRow.company.name}" width="150" />
</t:row>
<t:row id="g_26" >
<t:label id="g_27" text="Дата на основаване" width="150" />
<t:calendarfield id="g_28" value="#{d.CompanyInfoUI.selCompanyRow.company.date_established}" width="150" />
</t:row>
<t:row id="g_29" >
<t:label id="g_30" text="Булстат" width="150" />
<t:field id="g_31" text="#{d.CompanyInfoUI.selCompanyRow.company.bulstat}" width="150" />
</t:row>
<t:rowdistance id="g_32" />
<t:row id="g_33" >
<t:coldistance id="g_34" width="150" />
<t:button id="g_35" actionListener="#{d.CompanyInfoUI.onCompanySave}" text="Запис" />
</t:row>
</t:pane>
</t:row>
</t:rowbodypane>
<t:rowstatusbar id="g_36" />
<t:pageaddons id="g_pa"/>
</f:subview>
</h:form>
</f:view>
<!-- ========== CONTENT END ========== -->
