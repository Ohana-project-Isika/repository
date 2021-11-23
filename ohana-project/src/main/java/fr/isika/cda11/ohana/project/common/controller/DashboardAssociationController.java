package fr.isika.cda11.ohana.project.common.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;

import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;


import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.AssociationDto;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.AssociationService;
import fr.isika.cda11.ohana.project.membership.dto.MemberDto;
import fr.isika.cda11.ohana.project.membership.dto.MemberShipManageDto;
import fr.isika.cda11.ohana.project.membership.dto.MembershipDto;
import fr.isika.cda11.ohana.project.membership.service.MemberService;
import fr.isika.cda11.ohana.project.membership.service.MemberShipManageService;
import fr.isika.cda11.ohana.project.membership.service.MembershipService;


@Named
@RequestScoped
@ManagedBean
public class DashboardAssociationController implements Serializable {

	@Inject
	AssociationService assosService;
	@Inject
	MemberService memberService;
	@Inject
	AccountService accountService;
	@Inject
	MembershipService membershipService;
	@Inject
	MemberShipManageService mbsmService;

	private static final long serialVersionUID = 5285422635046708301L;
	private BarChartModel barModel;
	private DonutChartModel donutModel;
	private AccountDto accountDto = new AccountDto();
	private MemberDto memberDto = new MemberDto();
	private MembershipDto memberShipDto = new MembershipDto();
	private AssociationDto associationDto = new AssociationDto();
	private MemberShipManageDto mbsmDto = new MemberShipManageDto();
	List<MemberDto> members = new ArrayList<MemberDto>();

	public BarChartModel getBarModel() {return barModel;}
	public void setBarModel(BarChartModel barModel) {this.barModel = barModel;}
	public DonutChartModel getDonutModel() {return donutModel;}
	public void setDonutModel(DonutChartModel donutModel) {this.donutModel = donutModel;}
	public MemberService getMemberService() {return memberService;}
	public void setMemberService(MemberService memberService) {this.memberService = memberService;}
	public AccountDto getAccountDto() {return accountDto;}
	public void setAccountDto(AccountDto accountDto) {this.accountDto = accountDto;}
	public MemberDto getMemberDto() {return memberDto;}
	public void setMemberDto(MemberDto memberDto) {this.memberDto = memberDto;}
	public MembershipDto getMemberShipDto() {return memberShipDto;}
	public void setMemberShipDto(MembershipDto memberShipDto) {this.memberShipDto = memberShipDto;}
	public AssociationDto getAssociationDto() {return associationDto;}
	public void setAssociationDto(AssociationDto associationDto) {this.associationDto = associationDto;}
	public List<MemberDto> getMembers() {return members;}
	public void setMembers(List<MemberDto> members) {this.members = members;}	
	public MemberShipManageDto getMbsmDto() {return mbsmDto;}
	public void setMbsmDto(MemberShipManageDto mbsmDto) {this.mbsmDto = mbsmDto;}


	public String ReadListMemberByAssociation(Long id) {
		//je cherche l'association 
		associationDto = assosService.findAssociationByIdService(id);
		System.out.println("association dont l'id ="+id+"trouve:" +associationDto.toString());

		// je cherche le service adhesion relie a l'association
		List<MemberShipManageDto> mbsms = mbsmService.listMembershipManageService();
		for(MemberShipManageDto mbmdto : mbsms) {
			System.out.println("membershipmanage:"+mbmdto.toString());
			if(mbmdto.getAssociation().getIdAssos() == Long.valueOf(id)) {
				mbsmDto=mbmdto;
				System.out.println(mbsmDto.toString());
			}
			else {
				mbsmDto=new MemberShipManageDto();
			}
		}
		List<MembershipDto> allMembership = new ArrayList<MembershipDto>();
		allMembership = membershipService.listMembershipsService();
		List<MemberDto>memberdtos = memberService.listMembersService();
		for(MembershipDto membershdto: allMembership) {
			if(membershdto.getMemberShipManage().getId()==mbsmDto.getId()) {
				System.out.println("ligne110: "+membershdto.getPriceOfFee().doubleValue());
				mbsmDto.getMemberships().add(membershdto);
			}
			else {
				System.out.println("liste des membership est null");
			}
		}
		Double total=0.00;
		for(MembershipDto memberships : mbsmDto.getMemberships()) {
			for(MemberDto memberdto : memberdtos) {
				if(memberdto.getMembershipDto().getIdMbs()==memberships.getIdMbs()) {
					members.add(memberdto);
					System.out.println("ligne122: "+memberdto.getMembershipDto().getPriceOfFee().doubleValue());
					total= total +memberdto.getMembershipDto().getPriceOfFee().doubleValue();
				}
			}
		}

		//--------------------------------------------------------------------------

		barModel = new BarChartModel();
		ChartData data = new ChartData();

		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Total des ressources perçues");

		List<Number> values = new ArrayList<>();


		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		values.add(55);
		values.add(40);
		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		values.add(total.doubleValue());
		values.add(55);
		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 203, 207, 0.2)");
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("Janvier");
		labels.add("Fevrier");
		labels.add("Mars");
		labels.add("Avril");
		labels.add("Mai");
		labels.add("Juin");
		labels.add("Juillet");
		labels.add("Aout");
		labels.add("Septembre");
		labels.add("Octobre");
		labels.add("Novembre");
		labels.add("Decembre");
		data.setLabels(labels);
		barModel.setData(data);

		//Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("");
		options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel.setOptions(options);

		return "bar";

	}
	
	

	@PostConstruct
	public void init() {
		createDonutModel();

	}

	/*public void createBarModel() {
		barModel = new BarChartModel();
		ChartData data = new ChartData();

		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Total des ressources perçues sur 6 mois");

		List<Number> values = new ArrayList<>();


		Double total= Double.valueOf(0);

		for(int i=1; i==members.size(); i++) {
			System.out.println(members.get(i).getMembershipDto().getPriceOfFee());
		}
		System.out.println(total);

		values.add(total);
		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		values.add(55);
		values.add(40);
		barDataSet.setData(values);

		List<String> bgColor = new ArrayList<>();
		bgColor.add("rgba(255, 99, 132, 0.2)");
		bgColor.add("rgba(255, 159, 64, 0.2)");
		bgColor.add("rgba(255, 205, 86, 0.2)");
		bgColor.add("rgba(75, 192, 192, 0.2)");
		bgColor.add("rgba(54, 162, 235, 0.2)");
		bgColor.add("rgba(153, 102, 255, 0.2)");
		bgColor.add("rgba(201, 203, 207, 0.2)");
		barDataSet.setBackgroundColor(bgColor);

		List<String> borderColor = new ArrayList<>();
		borderColor.add("rgb(255, 99, 132)");
		borderColor.add("rgb(255, 159, 64)");
		borderColor.add("rgb(255, 205, 86)");
		borderColor.add("rgb(75, 192, 192)");
		borderColor.add("rgb(54, 162, 235)");
		borderColor.add("rgb(153, 102, 255)");
		borderColor.add("rgb(201, 203, 207)");
		barDataSet.setBorderColor(borderColor);
		barDataSet.setBorderWidth(1);

		data.addChartDataSet(barDataSet);

		List<String> labels = new ArrayList<>();
		labels.add("January");
		labels.add("February");
		labels.add("March");
		labels.add("April");
		labels.add("May");
		labels.add("June");
		labels.add("July");
		data.setLabels(labels);
		barModel.setData(data);

		//Options
		BarChartOptions options = new BarChartOptions();
		CartesianScales cScales = new CartesianScales();
		CartesianLinearAxes linearAxes = new CartesianLinearAxes();
		CartesianLinearTicks ticks = new CartesianLinearTicks();
		ticks.setBeginAtZero(true);
		linearAxes.setTicks(ticks);
		cScales.addYAxesData(linearAxes);
		options.setScales(cScales);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("");
		options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("top");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setFontStyle("bold");
		legendLabels.setFontColor("#2980B9");
		legendLabels.setFontSize(24);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		barModel.setOptions(options);
	}*/

	public void createDonutModel() {
		donutModel = new DonutChartModel();
		ChartData data = new ChartData();

		DonutChartDataSet dataSet = new DonutChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(300);
		values.add(50);
		values.add(100);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(60, 179, 113)");
		bgColors.add("rgb(54, 162, 235)");
		bgColors.add("rgb(255, 205, 86)");
		dataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		labels.add("Adhesion");
		labels.add("Crowdfunding");
		labels.add("Billeterie");
		data.setLabels(labels);

		donutModel.setData(data);
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}  

}