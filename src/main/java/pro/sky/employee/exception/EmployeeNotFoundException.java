package pro.sky.employee.exception;


public class EmployeeNotFoundException extends RuntimeException{
   public EmployeeNotFoundException(String message) {
      super(message);
   }
}
