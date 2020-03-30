<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<%@taglib prefix="t" uri="/WEB-INF/eclnt"%>


<!-- ========== CONTENT BEGIN ========== -->
<f:view>
<h:form>
<f:subview id="EmployeeInfog_sv">
<t:beanprocessing id="g_1" beanbinding="#{d.EmployeeInfoUI}" />
<t:rowtitlebar id="g_2" text="Служители" />
<t:rowheader id="g_3" />
<t:rowbodypane id="g_4" >
<t:row id="g_5" >
<t:fixgrid id="g_6" objectbinding="#{d.EmployeeInfoUI.sheet}" sbvisibleamount="15" width="100%" >
<t:gridcol id="g_7" width="20" >
<t:gridrowselector id="g_8" />
</t:gridcol>
<t:gridcol id="g_9" text="Име" width="150" >
<t:label id="g_10" text=".{firstName}" />
</t:gridcol>
<t:gridcol id="g_11" text="Презиме" width="150" >
<t:label id="g_12" text=".{secondName}" />
</t:gridcol>
<t:gridcol id="g_13" text="Фамилия" width="150" >
<t:label id="g_14" text=".{thirdName}" />
</t:gridcol>
<t:gridcol id="g_15" text="Възраст" width="100" >
<t:label id="g_16" text=".{age}" />
</t:gridcol>
<t:gridcol id="g_17" text="Фирма" width="100" >
<t:label id="g_18" text=".{companyName}" />
</t:gridcol>
<t:gridcol id="g_19" text="Дата на назначаване" width="150" >
<t:label id="g_20" format="date" text=".{dateStart}" />
</t:gridcol>
<t:gridcol id="g_21" text="Заплата" width="100" >
<t:label id="g_22" text=".{salary}" />
</t:gridcol>
<t:gridcol id="g_23" text="Банкова смека" width="200" >
<t:label id="g_24" text=".{iban}" />
</t:gridcol>
</t:fixgrid>
</t:row>
<t:rowdistance id="g_25" height="50" />
<t:rowtitlebar id="g_26" text="Детайли" />
<t:row id="g_27" >
<t:pane id="g_28" rowdistance="5" >
<t:rowdistance id="g_29" height="10" />
<t:row id="g_30" >
<t:label id="g_31" text="Име" width="150" />
<t:field id="g_32" text="#{d.EmployeeInfoUI.firstNameDetail}" width="150" />
</t:row>
<t:row id="g_33" >
<t:label id="g_34" text="Презиме" width="150" />
<t:field id="g_35" text="#{d.EmployeeInfoUI.secondNameDetail}" width="150" />
</t:row>
<t:row id="g_36" >
<t:label id="g_37" text="Фамилия" width="150" />
<t:field id="g_38" text="#{d.EmployeeInfoUI.thirdNameDetail}" width="150" />
</t:row>
<t:row id="g_39" >
<t:label id="g_40" text="Възраст" width="150" />
<t:formattedfield id="g_41" format="short" formatmask="short" value="#{d.EmployeeInfoUI.ageDetail}" width="150" />
</t:row>
<t:row id="g_42" >
<t:label id="g_43" text="Фирма" width="115" />
<t:button id="g_44" actionListener="#{d.EmployeeInfoUI.onCompanyEdit}" image="/images/pencil16.png" width="25" />
<t:coldistance id="g_45" width="10" />
<t:combofield id="g_46" actionListener="#{d.EmployeeInfoUI.onCompanyAction}" editable="false" text="#{d.EmployeeInfoUI.companyIdDetail}" width="50" />
<t:coldistance id="g_47" width="10" />
<t:label id="g_48" text="#{d.EmployeeInfoUI.companyNameDetail}" width="150" />
</t:row>
<t:row id="g_49" >
<t:label id="g_50" text="Дата на назначаване" width="150" />
<t:calendarfield id="g_51" value="#{d.EmployeeInfoUI.dateStartDetail}" width="150" />
</t:row>
<t:row id="g_52" >
<t:label id="g_53" text="Заплата" width="150" />
<t:field id="g_54" text="#{d.EmployeeInfoUI.salaryDetail}" width="150" />
</t:row>
<t:row id="g_55" >
<t:label id="g_56" text="Банкова сметка" width="150" />
<t:field id="g_57" text="#{d.EmployeeInfoUI.ibanDetail}" width="150" />
</t:row>
<t:rowdistance id="g_58" height="10" />
<t:row id="g_59" coldistance="5" >
<t:coldistance id="g_60" width="150" />
<t:button id="g_61" actionListener="#{d.EmployeeInfoUI.onEmployeeNew}" background="#b4c6e7" text="Нов" />
<t:button id="g_62" actionListener="#{d.EmployeeInfoUI.onEmployeeDelete}" background="#f4b183" text="Изтриване" />
<t:button id="g_63" actionListener="#{d.EmployeeInfoUI.onEmployeeSave}" background="#c5e0b3" text="Запис" />
</t:row>
</t:pane>
</t:row>
</t:rowbodypane>
<t:rowstatusbar id="g_64" />
<t:pageaddons id="g_pa"/>
</f:subview>
</h:form>
</f:view>
<!-- ========== CONTENT END ========== -->
