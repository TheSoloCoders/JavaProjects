package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class DemoData {

    /**
     * The Index.
     */
    private int index;

    /**
     * The Integration type.
     */
    private String integrationType;

    /**
     * The Data.
     */
    private Map<String, Object> data = new HashMap();

    /**
     * The Date attribute.
     */
    private List<String> dateAttribute = new ArrayList<>();

}
