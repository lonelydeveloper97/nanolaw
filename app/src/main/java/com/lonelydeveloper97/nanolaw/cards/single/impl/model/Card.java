package com.lonelydeveloper97.nanolaw.cards.single.impl.model;

import java.util.List;

public class Card {
    private final String name;
    private final List<String> mainInformation;
    private final List<String> actions;
    private final List<String> important;
    private final String detailedInfoLink;
    private final String usefulContacs;


    public Card(String name, List<String> mainInformation, List<String> actions, List<String> important, String detailedInfoLink, String usefulContacs) {
        this.name = name;
        this.mainInformation = mainInformation;
        this.actions = actions;
        this.important = important;
        this.detailedInfoLink = detailedInfoLink;
        this.usefulContacs = usefulContacs;
    }

    public String getName() {
        return name;
    }

    public List<String> getActions() {
        return actions;
    }

    public List<String> getImportant() {
        return important;
    }

    public List<String> getMainInformation() {
        return mainInformation;
    }

    public String getDetailedInfoLink() {
        return detailedInfoLink;
    }

    public String getUsefulContacs() {
        return usefulContacs;
    }
}
