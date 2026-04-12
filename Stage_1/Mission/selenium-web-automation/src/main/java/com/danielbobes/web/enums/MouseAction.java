package com.danielbobes.web.enums;

public enum MouseAction {

    LEFT_CLICK("Clic izquierdo"),
    RIGHT_CLICK("Clic derecho"),
    DOUBLE_CLICK("Doble clic izquierdo");

    private final String spanishDescription;

    MouseAction(String spanishDescription) {
        this.spanishDescription = spanishDescription;
    }

    public String getSpanishDescription() {
        return spanishDescription;
    }

    @Override
    public String toString() {
        return spanishDescription;
    }

}
