package modules;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Questions {

    private String imageName, question, choix1, choix2, reponse;
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


    public Questions(String imageName, String question, String choix1, String choix2, String reponse) {
        this.imageName = imageName;
        this.question = question;
        this.choix1 = choix1;
        this.choix2 = choix2;
        this.reponse = reponse;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoix1() {
        return choix1;
    }

    public void setChoix1(String choix1) {
        this.choix1 = choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public void setChoix2(String choix2) {
        this.choix2 = choix2;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "imageName='" + imageName + '\'' +
                ", question='" + question + '\'' +
                ", choix1='" + choix1 + '\'' +
                ", choix2='" + choix2 + '\'' +
                ", reponse='" + reponse + '\'' +
                '}';
    }

    public void FirebaseQuizz(String id)
    {
        ref.child("questions").child(id).setValue(this);

    }
    public static void questionsFB()
    {
        Questions q1 = new Questions("q1"," Je pourrais prendre ", "La première sortie","Les deuxième,troisième et quatrième sorties", "Les deuxième,troisième et quatrième sorties");
        q1.FirebaseQuizz("1");

        Questions q2 = new Questions("q2","A la prochaine intersection j'aurais la priorité : ", "Oui","Non", "Non");
        q2.FirebaseQuizz("2");

        Questions q3 = new Questions("q3"," Je peux dépasser ce véhicule :", "Oui","Non", "Oui");
        q3.FirebaseQuizz("3");

        Questions q4 = new Questions("q4"," Dans cette situation  : ", "Je passe","Je m'arrete", "Je passe");
        q4.FirebaseQuizz("4");

    }
}
