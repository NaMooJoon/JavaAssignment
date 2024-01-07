package org.example.school.student.constants;

public enum StudentType {
    NORMAL("NORMAL"),
    WHITE("WHITE"),
    BLACK("BLACK");

    String typeString;

    private StudentType(String typeString) {
        this.typeString = typeString;
    }

    public String getTypeString() {
        return typeString;
    }

    public static StudentType of(String typeString) {

        for (StudentType type : StudentType.values()) {
            if (type.getTypeString().equals(typeString.toUpperCase())) {
                return type;
            }
        }
        return NORMAL;
    }
}

