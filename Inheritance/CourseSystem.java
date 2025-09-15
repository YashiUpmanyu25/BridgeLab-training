// Core Course (kept simple)
class Course {
    private String courseName;
    private int duration; // weeks

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Extra feature: Online capability
class OnlineFeature {
    private String platform;
    private boolean isRecorded;

    public OnlineFeature(String platform, boolean isRecorded) {
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public void displayOnlineInfo() {
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Extra feature: Payment capability
class PaymentFeature {
    private double fee;
    private double discount;

    public PaymentFeature(double fee, double discount) {
        this.fee = fee;
        this.discount = discount;
    }

    public void displayPaymentInfo() {
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Final Price: $" + finalPrice);
    }
}

// Composed Course
class CustomCourse {
    private Course course;
    private OnlineFeature onlineFeature;
    private PaymentFeature paymentFeature;

    public CustomCourse(Course course, OnlineFeature onlineFeature, PaymentFeature paymentFeature) {
        this.course = course;
        this.onlineFeature = onlineFeature;
        this.paymentFeature = paymentFeature;
    }

    public void displayFullInfo() {
        course.displayInfo();
        if (onlineFeature != null) onlineFeature.displayOnlineInfo();
        if (paymentFeature != null) paymentFeature.displayPaymentInfo();
    }
}

// Main class
public class CourseSystem {
    public static void main(String[] args) {
        Course core = new Course("Java Programming", 8);
        OnlineFeature online = new OnlineFeature("Udemy", true);
        PaymentFeature payment = new PaymentFeature(199.99, 20);

        CustomCourse paidOnlineCourse = new CustomCourse(core, online, payment);

        System.out.println("=== Course Details ===");
        paidOnlineCourse.displayFullInfo();
    }
}
