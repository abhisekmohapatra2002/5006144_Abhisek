
public class BuilderPatternExample {

    static class Computer {
        private String CPU;
        private String RAM;

        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        public String getCPU() { return CPU; }
        public String getRAM() { return RAM; }
        public String getStorage() { return storage; }
        public String getGraphicsCard() { return graphicsCard; }
        public String getOperatingSystem() { return operatingSystem; }

        public static class Builder {
            private String CPU;
            private String RAM;

            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            public Builder(String CPU, String RAM) {
                this.CPU = CPU;
                this.RAM = RAM;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + 
                   ", storage=" + storage + ", graphicsCard=" + graphicsCard +
                   ", operatingSystem=" + operatingSystem + "]";
        }
    }

    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i7", "16GB")
                                .setGraphicsCard("NVIDIA RTX 3080")
                                .setStorage("1TB SSD")
                                .setOperatingSystem("Windows 10")
                                .build();

        Computer officePC = new Computer.Builder("Intel i5", "8GB")
                              .setStorage("512GB SSD")
                              .setOperatingSystem("Windows 10")
                              .build();

        Computer basicPC = new Computer.Builder("Intel i3", "4GB")
                             .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(basicPC);
    }
}


/*
output :-
-------
Computer [CPU=Intel i7, RAM=16GB, storage=1TB SSD, graphicsCard=NVIDIA RTX 3080, operatingSystem=Windows 10]
Computer [CPU=Intel i5, RAM=8GB, storage=512GB SSD, graphicsCard=null, operatingSystem=Windows 10]
Computer [CPU=Intel i3, RAM=4GB, storage=null, graphicsCard=null, operatingSystem=null]

*/
