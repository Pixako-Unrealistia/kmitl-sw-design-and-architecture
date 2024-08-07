public class MergedDatabase {
    private DatabaseAdapter databaseAdapter = new DatabaseAdapter();
    private RecordsAdapter recordsAdapter = new RecordsAdapter();
    private HashMap<Long, Employee> employees = new HashMap<Long, Employee>();

    public void addEmployee(Employee employee) {
        employees.put(employee.getEmpNum(), employee);
    }

    public void deleteEmployee(long emp_num) {
        // is employee in database?
        // check in hashmap
        if (employees.containsKey(emp_num)) {
            employees.remove(emp_num);
        } else if (databaseAdapter.isEmployee(emp_num)) {
            databaseAdapter.deleteEmployee(emp_num);
        } else if (recordsAdapter.isEmployee(emp_num)) {
            recordsAdapter.remove(emp_num);
        }
    }

    public Vector getAllEmployees() {
        Vector<Employee> allEmployees = new Vector<Employee>();
        allEmployees.addAll(employees.values());
        allEmployees.addAll(databaseAdapter.getAllEmployees());
        allEmployees.addAll(recordsAdapter.getAllEmployees());
        return allEmployees;
    }

    public boolean isEmployee(long emp_num) {
        return employees.containsKey(emp_num) || databaseAdapter.isEmployee(emp_num)
                || recordsAdapter.isEmployee(emp_num);
    }

}
