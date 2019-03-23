package com.jpmillan;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

import com.jpmillan.entity.Employee;


public class App {

	public static void main(String[] args) {

		// Supplier<Stream<Emp_Manager>> streamEmp = () -> Stream.<Emp_Manager>builder()
		// .add(new Emp_Manager("Alan", "100", "150")).add(new Emp_Manager("Martin",
		// "220", "100"))
		// .add(new Emp_Manager("Jamie", "150", null)).add(new Emp_Manager("Alex",
		// "275", "100"))
		// .add(new Emp_Manager("Steve", "400", "150")).add(new Emp_Manager("David",
		// "190", "400")).build();
		
		App thisSvc = new App();
		
		List<Employee> empList = thisSvc.getData();
		thisSvc.processHierarchy(empList);

	}

	public void processHierarchy(List<Employee> empList) {
		
		Map<String, String> empIdMap = new HashMap<>();
		Map<String, String> empMgrRelationMap = new HashMap<>();
		List<String> parents = new ArrayList<>();
		int startingSpacer = 1;
		
		empList.forEach(e -> {
			empIdMap.put(e.getId(), e.getEmployee_name());
			// handle erroneous mg id or self as mg id
			if (StringUtils.isEmpty(e.getManager_id()) || StringUtils.equals(e.getManager_id(), e.getId())) {
				parents.add(e.getId());
			} else {
				empMgrRelationMap.put(e.getId(), e.getManager_id());
			}
		});

		// handle employees with invalid managers
		empMgrRelationMap.keySet().forEach(e -> {
			if (!empIdMap.containsKey(empMgrRelationMap.get(e))) {
				parents.add(e);
			}
		});

		parents.forEach(e -> printIt(e, empMgrRelationMap, empIdMap, startingSpacer));

	}

	//representation of data
	public List<Employee> getData() {
		return new ArrayList<>(
				Arrays.asList(new Employee("Alan", "100", "150"),
						new Employee("Martin", "220", "100"),
						new Employee("Jamie", "150", null),
						new Employee("Alex", "275", "100"),
						new Employee("Steve", "400", "150"),
						new Employee("David", "190", "400")
				));



	}

	
	private void printIt(String managingId, Map<String, String> managingRelationMap, Map<String, String> idNameMap, int spacer) {
		
		System.out.println(String.format("%" + spacer * 10 + "s%-20s", "", idNameMap.get(managingId)));
		if (!managingRelationMap.containsValue(managingId)) {
			return;
		}
		managingRelationMap.entrySet().stream().filter(entry -> entry.getValue().equals(managingId)).forEach(entry -> printIt(entry.getKey(), managingRelationMap, idNameMap, spacer + 1));
	}

}
