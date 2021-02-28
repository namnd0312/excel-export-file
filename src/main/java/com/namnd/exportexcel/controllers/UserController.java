package com.namnd.exportexcel.controllers;

import com.namnd.exportexcel.dtos.UserDto;
import com.namnd.exportexcel.models.User;
import com.namnd.exportexcel.models.UserExcelExporter;
import com.namnd.exportexcel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author nam.nd
 * @created 28/02/2021 - 7:36 PM
 */


@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDto userDto){
        this.userService.saveUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-list")
    public ResponseEntity<?> getList(){
        List<UserDto> result = this.userService.getList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userService.getAll();

        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);

        excelExporter.export(response);
    }
}
