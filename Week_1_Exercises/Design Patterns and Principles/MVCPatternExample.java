class Learner {
    private String identifier;
    private String fullName;
    private String classGrade;

    public Learner(String identifier, String fullName, String classGrade) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.classGrade = classGrade;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }
}

class LearnerView {
    public void showLearnerDetails(String name, String id, String grade) {
        System.out.println("Learner Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

class LearnerController {
    private Learner model;
    private LearnerView view;

    public LearnerController(Learner model, LearnerView view) {
        this.model = model;
        this.view = view;
    }

    public void setLearnerName(String name) {
        model.setFullName(name);
    }

    public String getLearnerName() {
        return model.getFullName();
    }

    public void setLearnerId(String id) {
        model.setIdentifier(id);
    }

    public String getLearnerId() {
        return model.getIdentifier();
    }

    public void setLearnerGrade(String grade) {
        model.setClassGrade(grade);
    }

    public String getLearnerGrade() {
        return model.getClassGrade();
    }

    public void updateView() {
        view.showLearnerDetails(model.getFullName(), model.getIdentifier(), model.getClassGrade());
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        Learner model = new Learner("1", "Ankitha", "A");
        LearnerView view = new LearnerView();
        LearnerController controller = new LearnerController(model, view);

        controller.updateView();
        controller.setLearnerName("Sirisha");
        controller.setLearnerGrade("B");
        controller.updateView();
    }
}
