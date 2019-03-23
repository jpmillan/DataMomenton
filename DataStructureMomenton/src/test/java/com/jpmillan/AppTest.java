package com.jpmillan;

import java.util.List;
import java.util.stream.Collectors;


import com.jpmillan.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App appSvc;
    List<Employee> empList;

    @BeforeEach
    public void init() {
        appSvc = new App();
        empList = appSvc.getData();

    }

    @Test
    @DisplayName("Test if object has initial Content List")
    public void dataHasInitialContentList() {

        assertAll("Data Has Initial Content List",
                () -> assertNotNull(empList),
                () -> assertFalse(empList.isEmpty()),
                () -> assertEquals(empList.size(), 6)
        );
    }


    @Test
    @DisplayName("Test if CEO exists")
    public void dataContainsCEO() {
        assertTrue(empList.stream().anyMatch(emp -> emp.getEmployee_name().equals("Jamie")));

    }

    @Test
    @DisplayName("Test structure can contain multiple unmanaged employees")
    public void dataCanContainMultipleUnmanagedEmployees() {

        empList.add(new Employee("Nick", "500", null));


        appSvc.processHierarchy(empList);

        assertEquals(empList.stream()
                        .filter(e -> e.getManager_id() == null)
                        .collect(Collectors.toList())
                        .size()
                , 2);


    }


    @Test
    @DisplayName("Test if data can have invalid manager")
    public void dataCanContainInvalidManagers() {

        empList.add(new Employee("Lee", "550", "999"));

        Exception ex = null;

        try {
            appSvc.processHierarchy(empList);
        } catch (Exception e) {
            ex = e;
        }

        assertNull(ex);

    }

    @Test
    @DisplayName("Test if data can contain self managing employees")
    public void dataCanContainSelfManagingEmployees() {

        App appSvc = new App();
        List<Employee> empList = appSvc.getData();
        empList.add(new Employee("Jason", "450", "450"));

        Exception ex = null;
        try {
            appSvc.processHierarchy(empList);
        } catch (Exception e) {
            ex = e;
        }

        assertNull(ex);

    }

    @AfterEach
    public void cleanup(){
        appSvc = null;
        empList = null;
    }
}
