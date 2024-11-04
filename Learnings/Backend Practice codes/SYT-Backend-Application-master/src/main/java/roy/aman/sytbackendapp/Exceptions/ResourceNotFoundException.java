package roy.aman.sytbackendapp.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

//    private String resourceName;
//    private String fieldName;
//    private Integer fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(resourceName + " is not found with " + fieldName + " " + fieldValue);

    }

}
