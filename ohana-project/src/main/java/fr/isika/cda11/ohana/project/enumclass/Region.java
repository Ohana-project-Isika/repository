package fr.isika.cda11.ohana.project.enumclass;

import lombok.Getter;

@Getter
public enum Region {
    CORSE (new String[] {"2A", "2B"}),
    CVDL (new String[] {"18", "28", "36", "37", "41", "45"}),
    BRETAGNE (new String[] {"22", "29", "35", "56"}),
    BFC (new String[] {"21", "25", "39", "58", "70", "71", "89", "90"}),
    GE (new String[] {"08", "10", "51", "52", "54", "55", "57", "67", "68", "88"}),
    OCCITANIE (new String[] {"09", "11", "12", "30", "31", "32", "34", "46", "48", "65", "66", "81", "82"}),
    HDF (new String[] {"02", "59", "60", "62", "80"}),
    ARA (new  String[] {"01", "03", "07", "15", "26", "38", "42", "43", "63", "69", "73", "74"}),
    NORMANDIE (new String[] {"14", "27", "50", "61", "76"}),
    PDLL (new String[] {"44", "49", "53", "72", "85"}),
    PACA (new String[] {"04", "05", "06", "13", "83", "84"}),
    IDF (new String[] {"75", "77", "78", "91", "92", "93", "94", "95" }),
    NA (new String[] {"16", "17", "19", "23", "24", "33", "40", "47", "64", "79", "86", "87"}),
    GUYANE (new String[] {"973"}),
    MARTINIQUE (new String[] {"972"}),
    MAYOTTE (new String[] {"976"}),
    GUADELOUPE (new String[] {"971"}),
    REUNION (new String[] {"974"});

    private final String[] departments;

    Region(String[] departments) {
        this.departments = departments;
    }
}
