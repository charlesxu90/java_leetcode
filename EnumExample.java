public class EnumExample {
    public enum Company {
        EBAY, PAYPAL, GOOGLE, YAHOO, ATT
    }

    Company cName;

    public EnumExample (Company cName) {
        this.cName = cName;
    }

    public void companyDetails() {
        switch (cName) {
            case EBAY:
                System.out.println("Biggest Market Place in US!");
                break;
            case PAYPAL:
                System.out.println("Simplest way to manage money.");
                break;
            default:
                System.out.println("No comments for this Company!");
        }
    }

    public static void main (String args[]) {
        EnumExample eexp = new EnumExample(Company.GOOGLE);
        eexp.companyDetails();
    }
}
