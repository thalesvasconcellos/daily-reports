package com.vasconcellos.dailyreport.mapper;

import com.vasconcellos.dailyreport.dto.NoteDto;
import com.vasconcellos.dailyreport.model.Employee;
import com.vasconcellos.dailyreport.model.Note;
import com.vasconcellos.dailyreport.model.Order;
import com.vasconcellos.dailyreport.model.Report;
import com.vasconcellos.dailyreport.service.EmployeeService;
import com.vasconcellos.dailyreport.service.OrderService;
import com.vasconcellos.dailyreport.service.ReportService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class NoteMapper {

    @Autowired
    private ReportService reportService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderService orderService;

    @Mapping(source = "reportId", target = "report", qualifiedByName = "mapReportById")
    @Mapping(source = "employeeId", target = "employee", qualifiedByName = "mapEmployeeById")
    @Mapping(source = "orderId", target = "order", qualifiedByName = "mapOrderById")
    @Mapping(target = "imagesUrl", ignore = true)
    public abstract Note toEntity(NoteDto noteDto);

    @Mapping(source = "report.id", target = "reportId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "order.id", target = "orderId")
    public abstract NoteDto toDto(Note note);

    @Named("mapReportById")
    public Report mapReportById(Long id) {
        return reportService.findById(id);
    }

    @Named("mapEmployeeById")
    public Employee mapEmployeeById(Long id) {
        return employeeService.findById(id);
    }

    @Named("mapOrderById")
    public Order mapOrderById(Long id) {
        return orderService.findById(id);
    }
}