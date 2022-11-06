package by.bsuir.lab2.entity.criteria;


public final class SearchCriteria {
    private SearchCriteria() {
    }

    public static enum Speakers {
        POWER_CONSUMPTION,
        NUMBER_OF_SPEAKERS,
        FREQUENCY_RANGE,
        CORD_LENGTH;

        private Speakers() {
        }
    }

    public static enum Kettle {
        VOLUME,
        POWER_CONSUMPTION,
        CORD_LENGTH,
        WEIGHT;

        private Kettle() {
        }
    }

    public static enum Laptop {
        BATTERY_CAPACITY,
        OS,
        MEMORY_ROM,
        SYSTEM_MEMORY,
        CPU,
        DISPLAY_INCHS;

        private Laptop() {
        }
    }

    public static enum Oven {
        POWER_CONSUMPTION,
        WEIGHT,
        CAPACITY,
        DEPTH,
        HEIGHT,
        WIDTH;

        private Oven() {
        }
    }
}
