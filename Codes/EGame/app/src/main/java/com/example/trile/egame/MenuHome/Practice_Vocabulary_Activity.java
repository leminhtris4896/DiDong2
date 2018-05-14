package com.example.trile.egame.MenuHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.trile.egame.Models.mdLearn;
import com.example.trile.egame.R;
import com.example.trile.egame.Theme.Theme_Animal;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Practice_Vocabulary_Activity extends AppCompatActivity {

    private ImageView imgCLOSETHEME;
    private ImageView closeTheme;
    private LinearLayout btn_Animal;
    private LinearLayout btn_Study;
    private LinearLayout btn_Family;
    private LinearLayout btn_Object;
    private LinearLayout btn_Country;
    private LinearLayout btn_Transport;
    private ArrayList<mdLearn> arrayListAnimal;
    private ArrayList<mdLearn> arrayListStudy,arrayListFamily,arrayListObject,arrayListCountry,arrayListTransport;
    DatabaseReference mData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_vocabulary_layout);

        initView();

        mData = FirebaseDatabase.getInstance().getReference();

       /* String key = mData.child("Charts").push().getKey();
        mdTop mdTop = new mdTop("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bus.jpg?alt=media&token=593abfe9-af76-4162-b458-17b1c186020a","Sơn","100");
        mData.child("Charts").child(key).setValue(mdTop);

        String key1 = mData.child("Charts").push().getKey();
        mdTop mdTop1 = new mdTop("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bus.jpg?alt=media&token=593abfe9-af76-4162-b458-17b1c186020a","Đặng Sơn","200");
        mData.child("Charts").child(key1).setValue(mdTop1);*/
       /* // Animal
        arrayListAnimal = new ArrayList<>();
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bee_resize.jpg?alt=media&token=9e2f1044-b097-41ba-9fb6-d610445a8177", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bee.mp3?alt=media&token=4f776843-4a65-4659-b9d5-0a53cadacef4", "Bee", "/ bi: /", "Con ong", "Beautiful bee is sitting on the window\nChú ong tuyệt đẹp đang đậu trên cửa sổ","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bird_resize.jpg?alt=media&token=99c8b86e-6b05-4ef2-ad80-540a24870303", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bird_resize.jpg?alt=media&token=99c8b86e-6b05-4ef2-ad80-540a24870303", "Bird", "/ bɜ:d /", "Con chim", "See the food, the birds fly to countless many\nThấy thức ăn, lũ chim bay đến nhiều không đếm được","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/buffalo_resize.jpg?alt=media&token=c74e9310-edff-4b1c-b19c-9da96166590a", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/buffalo.mp3?alt=media&token=8d6a474e-8de4-4901-a1f4-19f74ee15302", "Buffalo", "/ 'bʌfələʊ /", "Con trâu", "Buffalo used to pull the plow, also used to pull the car\n","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/buttefly_resize.jpg?alt=media&token=a54b0811-32ae-40db-96af-1436ce5e738f", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/butterfly.mp3?alt=media&token=fb0a5451-af5f-4052-9810-ade9e5badb22", "Buttefly", "/ 'bʌtəflai /", "Con bướm", "Not only the diversity of species, the butterfly also has many colors.\nKhông những đa dạng về chủng loại, con bướm còn có rất nhiều màu sắc.","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cat.jpg?alt=media&token=d14be30a-9fc4-4c98-94d2-24c3258d325f", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cat.mp3?alt=media&token=ce14eec8-6584-4cb1-95e2-8f6864c82e97", "Cat", "/ kæt /", "Con mèo", "People hate to hate each other like dogs and cats\nNgười ta thường nói ghét nhau như chó với mèo","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/chicken.jpg?alt=media&token=29e6584b-1a18-4543-8397-189bef7f48b1", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/chicken.mp3?alt=media&token=2171e55f-3d0a-4566-abf6-a00c62eace84", "Chicken", "/ 't∫ikin / ", "Con gà", "Early in the morning, the chickens often wake up to wake up people\nSáng sớm, những chú gà thường gáy để đánh thức mọi người","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dinosaur.jpg?alt=media&token=a7f70444-b145-41e3-b835-1f201ef49372", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dinosaur.mp3?alt=media&token=37a9d384-eb04-4785-a831-8461582d8f4d", "Dinosaur", "/ 'dainəsɔ:r /", "Khủng long", "Although extinct, the dinosaurs are still alive as they live through popular films\nMặc dù đã tuyệt chủng, nhưng những chú khủng long vẫn như còn tồn tại sống động qua các bộ phim nổi tiếng","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dog.jpg?alt=media&token=2018fdd4-8b4e-4689-9260-c927f5b8c57a", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dog.mp3?alt=media&token=0118dade-0df9-419c-9916-123373265fed", "Dog", "/ dɔ:g /", "Con chó", "Dogs are loyal friends with humans\nChó là người bạn trung thành với con người","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/fish.jpg?alt=media&token=e58b4150-75d9-4abe-abd7-96f9cd5a3420", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/fish.mp3?alt=media&token=0e542ef2-b0a5-496e-b3e2-c10c492c6eb7", "Fish", "/ fi∫ /", "Con cá", "Fish is nutritious food\nCá là thức ăn giàu dinh dưỡng","animal"));
        arrayListAnimal.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pig.jpg?alt=media&token=c785d0f9-c114-4dd1-93f9-5ab2c3e60e57", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pig.mp3?alt=media&token=147ccfa1-79bb-4014-a06f-2ea61f84305f", "Pig", "/ pig /", "Con heo", "The pigs are so cute\nNhững chú heo đất trong thật dễ thương","animal"));
        mData.child("Animal").setValue(arrayListAnimal);


        // Study
        arrayListStudy = new ArrayList<>();

        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/teacher.jpg?alt=media&token=08ab117b-99bb-49b3-ac1e-e9386f327182", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/teacher.mp3?alt=media&token=dd459dca-204b-4d41-b8da-c9bda6ee03ac", "Teacher", " /'ti:t∫ə[r]/ ", "Giáo viên", "My teacher is very beautiful\nGiáo viên của tôi rất là xinh đẹp","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/school.jpg?alt=media&token=de584b14-1e28-4627-b2ea-ba2f1d8dd815", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/school.mp3?alt=media&token=b1992322-66d5-45ad-8baf-f690fd8d2e73", "School", "/sku:l/ ", "Trường học", "School is the place to train every adult.\nTrường học là nơi rèn luyện mỗi con người trưởng thành hơn.","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subject.jpg?alt=media&token=5d4b8539-c3a8-4a45-a691-3bc53cd0e624", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subject.mp3?alt=media&token=5c5c2a93-a600-4d02-9138-f89d46d0ea46", "Subject", "", "Môn học", "Lots of many subjects\nCó rất nhiều môn học","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/school%20bag.jpg?alt=media&token=225f72cc-5bd7-4683-96af-9c0493f89a06", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/school%20bag.mp3?alt=media&token=5beb2b13-1129-4515-bfc9-e6986699f917", "School bag", "", "Cặp sách", "School bags are not something none of every student can do\nCặp sách là thứ không thể không có của mỗi học sinh","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/physical%20education.jpg?alt=media&token=e155647a-3f4c-4b4b-b6a8-f1754e051f44", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/physical%20education.mp3?alt=media&token=691db1fd-35e0-47d7-836c-f4b527d7160f", "Physical education", "", "Môn thể dục", "Physical education is a discipline that helps students to improve their health\nGiáo dục thể chất  là môn học giúp học sinh rèn luyện sức khỏe","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pencil%20sharpener.jpg?alt=media&token=1bd313a2-e468-44d3-aac7-5b3d1352ba39", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pencil%20sharpener.mp3?alt=media&token=c62f8f81-e620-40f4-bdc7-65a7cdc74062", "Pencil sharpener", " /'pensl ∫ɑ:pənə[r]/ ", "Cái gọt bút chì", "Pencil sharpener has many styles and colors\nGọt bút chì có rất nhiều kiểu và màu sắc","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/librarian.jpg?alt=media&token=302f79c4-6076-46b5-a51e-20d910b6d150", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/librarian.mp3?alt=media&token=00981eeb-3d96-48c6-8b68-29921eef661e", "Librarian", "/lai'breəriən/", "Thủ thư", "School librarians are very friendly\nNgười thủ thư trường tôi rất thân thiện","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/homework.jpg?alt=media&token=48a0e462-ebee-48fd-96d5-e1e977cdace4", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/home%20work.mp3?alt=media&token=fb773e49-f583-43f4-89e5-c640ac5e3710", "Homework", "/'həʊmwɜ:k/", "Bài tập về nhà", "All students must do homework\nHọc sinh nào cũng phải làm bài tập về nhà","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/exam_.jpg?alt=media&token=55dd2b0a-116d-4c0b-8dad-ba88e2f36cd1", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Exam.mp3?alt=media&token=62bebdf8-d134-44bd-a800-026ba9bf53a6", "Exam", "/ig'zæm/", "Kì thi", "Exam is really pressure\nKì thi thật là áp lực","learn"));
        arrayListStudy.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/class%20president.jpg?alt=media&token=6283d971-391c-40e3-8ba8-2f26a9a234da", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Exam.mp3?alt=media&token=62bebdf8-d134-44bd-a800-026ba9bf53a6", "Class president", "", "Lớp trưởng", "The class president has the most power in the class\nLớp trưởng có quyền lực nhất trong lớp","learn"));

        mData.child("Study").setValue(arrayListStudy);

        // Object
        arrayListObject = new ArrayList<>();

        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/air-condition.jpg?alt=media&token=f3bca591-58f1-4822-9cae-c41ee0edab5a", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/air-conditioner.mp3?alt=media&token=9dcca6e5-c580-4427-aabe-a01a88a267f6", "Air-condition", "/'eəkən'di∫n/ ", "Máy điều hòa", "Air conditioners usually turn up at full capacity during the summer\nMáy lạnh thường bật hết công suất trong mùa hè","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bed.jpg?alt=media&token=979aedf8-d71b-4c86-a898-11e050d9067c", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bed.mp3?alt=media&token=c62d0927-00f8-440f-97e3-0f09e8877cf8", "Bed", "/bed/ ", "Cái giường", "Bed of couple true colors\nGiường ngủ của đôi uyên ương thật nhiều màu sắc","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/blanket.jpg?alt=media&token=cc270b4b-4f49-4336-9765-1b3baeb33e2e", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/blanket.mp3?alt=media&token=5104c62d-908d-4058-9c93-06c6b17d4ec5", "Blanket", "/'blæŋkit/ ", "Cái mền", "It was cold enough for two blankets to appear\nTrời lạnh thì hai cái mền có vẻ mới đủ","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bookshelf.jpg?alt=media&token=239e5233-f21c-48ad-8d17-2f94f3eeb356", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bookshelf%20.mp3?alt=media&token=170e7150-3df2-4539-99d2-d4bc77c24ed5", "Bookshelf", "/ˈbʊkˌʃɛlf/ ", "Giá sách", "Bookshelf is essential for every student\nGiá sách rất cần thiết đối với mỗi học sinh","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/chair.jpg?alt=media&token=149dcfe1-d19d-48b4-8013-37d127d2797e", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/chair.mp3?alt=media&token=47b259fb-230c-42ce-9b48-f102f59f52dd", "Chair", "/t∫eə[r]/", "Cái ghế", "Chair is very popular in the kitchen of every family\nGhế tựa rất phổ biến trong căn bếp của mỗi gia đình","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/clock.jpg?alt=media&token=447de619-6b96-4b86-acc9-ea0bbefec35a", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/clock.mp3?alt=media&token=1ce10f89-106b-4348-a4f9-c865bea414d0", "Clock", "/klɒk/", "Đồng hồ", "Watches are the decisive object of anyone wanting to make use of time effectively\nĐồng hồ là vật bất ly thân của ai muốn tận dụng thời gian hiệu quả","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/computer.jpg?alt=media&token=32e718eb-18f1-4af3-b4ef-846457f80bc3", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/computer.mp3?alt=media&token=c5469bb6-f398-435f-ab03-35e3cbc35f5f", "Computer", "/kəm'pju:tə[r]/ ", "Máy tính", "Today, high performance computers dizzy\nNgày nay, máy tính có hiệu suất cao chóng mặt","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/fan.jpg?alt=media&token=f899d701-1107-4c28-a19e-c44163aab4fe", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/fan.mp3?alt=media&token=73126580-f2b2-4cb4-99a2-cc5d4e2b84ad", "Fan", "/fæn/ ", "Cái quạt", "Fan is indispensable for every family in the summer\nQuạt là vật không thể thiếu của mỗi gia đình trong mùa hè","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pillow.jpg?alt=media&token=16074bd8-af61-4c9a-8ee1-c5686e8308b3", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pillow.mp3?alt=media&token=2f30ae3f-9b7a-4fa2-8635-e24ec3a5b893", "Pillow", "/'piləʊ/", "Cái gối", "Pillows come in a variety of colors\nGối có nhiều loại và nhiều màu sắc","object"));
        arrayListObject.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/television.jpg?alt=media&token=37585606-87e5-482a-85ee-ff76b83d0302", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/television.mp3?alt=media&token=fab89832-50d5-401b-b98c-0e80b2006307", "Television", "/'teliviʒn/", "Truyền hình ti vi", "Today's television is thin and lightweight\nTivi ngày nay mỏng và nhẹ rất nhiều","object"));

        mData.child("Object").setValue(arrayListObject);

        // Country
        arrayListCountry = new ArrayList<>();

        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Japan.png?alt=media&token=428d77de-4ce9-4b8e-a86b-b55829304080", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Japan.mp3?alt=media&token=1359c2fb-175d-45d2-b251-17f84e121ff1", "Japan", "/ʤəˈpæn/ ", "Nhật bản", "Japan has a unique culture\nNhật Bản có một nền văn hóa độc đáo","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ANh.png?alt=media&token=e7c30363-e10f-49e3-90ec-9723226ac30b", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/England.mp3?alt=media&token=ec39f390-13c3-4b8e-82b8-b6320b9f03ea", "England", "/ˈɪŋglənd/ ", "Anh", "London is the capital of England\nLuân đôn là thủ đô của nước anh","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ando.png?alt=media&token=e2bf0d84-d913-414a-bcd4-8084892ac090", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/India.mp3?alt=media&token=91f29024-f723-46b1-8f27-1b0aa2fb17fd", "India ", "/ˈɪndɪə/ ", "Ấn độ", "India has the second largest population in the world\nNước ấn độ có dân số lớn thứ hai trên thế giới","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/singapore.png?alt=media&token=6ec0f50b-360b-418a-a7b4-a3bd64b98ed2", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/singapore.mp3?alt=media&token=cfff402f-7575-4836-a857-00f75a38531f", "Singapore ", "/sɪŋgəˈpɔː/ ", "Singapore", "Singapore has an area of 719.9 km²\nSingapore có diện tích 719,9 km²","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cambodia.png?alt=media&token=7e6c7fae-2850-4df5-90e6-fb727fad6af0", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Cambodia.mp3?alt=media&token=40cb0c74-06ee-4599-8c79-b650f2b8209e", "Combodia ", "/Combodia / ", "Campuchia", "Phnom Penh is the capital of Cambodia\nPhnôm Pênh là thủ đô của Campuchia","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/My.png?alt=media&token=4bd46de6-d8c0-4e06-97e6-1e76e0506d86", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/America.mp3?alt=media&token=09f09e72-acef-4988-9504-a5f28761c0e6", "America ", "/əˈmɛrɪkə/ ", "Mỹ", "Washington is the capital of America\nWashington là thủ đô của nước Mỹ","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/canada.png?alt=media&token=e2495e65-fd25-4077-bc91-0d2a54af8ca6", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Canada.mp3?alt=media&token=68d35be9-b14b-4f27-bca1-5433109cd1db", "Canada ", "/ˈkænədə/ ", "Canada", "Ottawa is the capital of Canada\nOttawa là thủ đô của Canada","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/DanMach.png?alt=media&token=d1775e9b-45a8-4597-98cd-85e4acfc5ce4", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Denmark.mp3?alt=media&token=bc80e41b-c929-41d5-9356-fe08653e2fde", "Denmark", "/ˈdɛnmɑːk/ ", "Đan mạch", "Copenhagen is the capital of Denmark\nCopenhagen là thủ đô của Đan Mạch","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Uc.png?alt=media&token=a49e0d93-7e00-4a5f-9663-fc2b9502d83e", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Australia.mp3?alt=media&token=0d20cdd2-0e48-4312-b291-54e32fc43fd0", "Australia", "/ɒˈstreɪliːə / ", "Úc", "Canberra is the capital of Australia\nCanberra là thủ đô của nước  Úc","country"));
        arrayListCountry.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Nga.png?alt=media&token=9a42e6d0-8e5f-464b-89dd-a38ac7efa85a", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/rusia.mp3?alt=media&token=a8d468aa-d502-4824-a792-70101b556f79", "Russia", "/ˈrʌʃə/ ", "Nga", "Moscow is the capital of Russia\nMoskva là thủ đô của nước  Nga","country"));

        mData.child("Country").setValue(arrayListCountry);

        // Family
        arrayListFamily = new ArrayList<>();

        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/mum.jpg?alt=media&token=a60b34f5-0b0f-4901-be8a-53fd4842a5c5", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/mum.mp3?alt=media&token=d6d8d52a-cff4-447c-bf42-8907555c147c", "Mum", "/mʌm/", "Mẹ", "Mum cook delicious rice\nMẹ nấu cơm ngon","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Dad.jpg?alt=media&token=e4362e31-59d7-4f6e-9a6d-e9a7d1ddf86b", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dad.mp3?alt=media&token=66357e91-ef88-4e9d-9f63-774f892c78af", "Dad", "/dæd/", "Ba", "Dad cooks very well\nCha tôi nấu ăn rất ngon","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/family.jpg?alt=media&token=47f81419-b368-41f6-801e-0c500807ac9f", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/family%20.mp3?alt=media&token=baf7109f-c41d-4073-8708-6457a35ba959", "Family", "/'fæmili/", "Gia đình", "My family has 5 brothers and sisters\nGia đình tôi có 5 anh chị em","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/aunt.jpg?alt=media&token=5a152ddd-fcaf-44a0-8c30-66162973821d", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/aunt.mp3?alt=media&token=59508b58-c2f4-4c9d-a6cc-32ae1d4753d0", "Aunt", "/ɑ:nt/", "Cô , Dì", "Aunt i'm pretty and good\nDì tôi dẹp và tốt","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/uncle.jpg?alt=media&token=dbf20df2-e3a2-452e-8b90-08b040cfdda0", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/uncle.mp3?alt=media&token=ea6cc4d5-ad38-4647-9056-4aa305b73ff8", "Uncle", "/'ʌɳkl/ ", "Chú , Bác", "My uncle is in the city\nNhà chú tôi nằm ở thành phố","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/brother.jpg?alt=media&token=50b993da-9dee-4e01-95ec-ef8d0caa84ec", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/brother.mp3?alt=media&token=7e2cb74a-39f7-47ea-a6e8-c4f83d9944b5", "Brother", "/'brʌðə/ ", "Anh , Em trai", "my brother is interested in everyone\nanh tôi biết quan tâm đến mọi người","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subject.jpg?alt=media&token=5d4b8539-c3a8-4a45-a691-3bc53cd0e624", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/sister.mp3?alt=media&token=a9c640f2-8af3-4df3-a79a-83e421c1709d", "Sister", "/'sistə/ ", "Chị , em gái", "my sister is going to marry her\nchị tôi sắp cưới chồng","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/grandmother.jpg?alt=media&token=6f66eb09-9e18-4acc-9a32-6946d6bbb479", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/grandmother%20.mp3?alt=media&token=26e19835-a8cb-4542-a4c9-892f7c435655", "Grandmother", "/'græn,mʌðə/ ", "Bà ngoại , bà nội", "My grandmother was 80 years old but still healthy\nbà nôi tôi năm nay đã ngoài 80 tuổi nhưng vẫn còn khỏe","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/grandfather.jpg?alt=media&token=33d36a7f-de9c-4600-9a04-bee2b58cd39e", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/grandfather%20.mp3?alt=media&token=c2d71b86-f92c-4911-b734-607d3d74a3c3", "Grandfather", "/'grænd,fɑ:ðə/", "Ông nội , bà nội", "My grandfather this year is over 80 years old but still healthy\nông nội tôi năm nay đã ngoài 80 tuổi nhưng vẫn còn khỏe","family"));
        arrayListFamily.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cousin.jpg?alt=media&token=acb10cc2-1d51-4d84-9f04-ec405b89328e", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cousin.mp3?alt=media&token=40e2626d-7007-43f9-b605-cc00423a9751", "Cousin", "/'kʌzn/", "Anh em , em họ", "My cousin is currently working in Ho Chi Minh City\nanh họ tôi hiện đang công tác tại thành phố hồ chí minh","family"));

        mData.child("Family").setValue(arrayListFamily);

        // Transport
        arrayListTransport = new ArrayList<>();

        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bus.jpg?alt=media&token=593abfe9-af76-4162-b458-17b1c186020a", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bus.mp3?alt=media&token=1ec5e5a1-cf0b-40de-a421-0027118ef01e", "Bus", "/bʌs/", "Xe bus", "Ho Chi Minh City has many bus routes\nThành phố Hồ Chí Minh có nhiều tuyến xe buýt","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/car.jpg?alt=media&token=4457479f-1376-4df5-8390-ce6a5161f76d", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/car.mp3?alt=media&token=26cbe679-ca45-4b80-b6a8-5af3819d9ce8", "Car", "/kɑːr/", "Xe hơi", "My house has a car\nnhà tôi có 1 chiếc xe hơi","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bicycle.jpg?alt=media&token=0da8b373-d289-4032-98ce-e99a11f895cd", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bicycle.mp3?alt=media&token=9a9ed958-6b4b-43a4-9fe3-9e6e3d3af97a", "Bicycle", "/ˈbaɪsɪkl/ ", "Xe đạp", "My home has a bicycle but no one goes\nNhà tôi có xe đạp nhưng không ai đi","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/truck.jpg?alt=media&token=f7b26961-d5f6-4ad5-ac17-00cef893ff3e", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/truck.mp3?alt=media&token=5c7bc986-e4ea-465f-ba02-cd9afc5eb94c", "Truck", "/trʌk/", "Xe tải", "I have a truck repair shop\nnhà em có 1 xưởng sửa chữa xe tải","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/scrooter.jpg?alt=media&token=4249b071-4fa7-4b89-8d34-64dc603fccb4", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/scooter.mp3?alt=media&token=6d055ce3-130f-4733-ae28-8592ade70302", "Scrooter", " /ˈskuːtər/", "Xe tay ga", "I have the money to buy gas car but I do not buy\nem có dư tiền mua xe tai ga nhưng em không mua","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/train.mp3?alt=media&token=a1b146bd-c277-4e0f-b443-ab1f403fbec1", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/train.mp3?alt=media&token=a1b146bd-c277-4e0f-b443-ab1f403fbec1", "Train", "/treɪn/", "Xe lửa", "The train has a lot of trailers\nxe lửa có rất nhiều toa ","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subway.jpg?alt=media&token=e266d141-8fec-46f6-b380-c67113bf7379", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subway.mp3?alt=media&token=8fa6f445-da55-48e6-97e8-fd8cb7f81582", "Subway", "/ˈsʌbweɪ/", "Tàu điện ngầm", "Vietnam currently has no subway\nnước việt nam hiện tại chưa có tầu điện ngầm","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/motorbike.jpg?alt=media&token=ff0ec710-22d1-4d5c-b7a8-6ad04c7bfab4", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/motobike.mp3?alt=media&token=8c891e33-bf4c-49b1-8c76-dd2dce496782", "Motorbike", "/ˈməʊtəbaɪk/", "Xe máy", "My friend bought a motorbike\nbạn tôi mới mua xe máy","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/xe%20cap%20cuu.jpg?alt=media&token=f0297fcb-a842-47ad-83f8-c5c0dc97ff02", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ambulance.mp3?alt=media&token=332c8a8e-144f-4bd1-b41e-39f7727b1c4e", "Ambulance", "/'æmbjuləns/", "Xe cấp cú", "An ambulance used to be a patient\nxe cấp cứu dùng để trở bệnh nhân","transport"));
        arrayListTransport.add(new mdLearn("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/taxi.jpg?alt=media&token=72645729-6498-4ced-9201-d724ab26b7fb", "https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/taxi.mp3?alt=media&token=05f67044-80bf-4501-9328-bfb9be4b9c55", "Taxi", "/'tæksi/", "Xe taxi", "Vietnam has many taxi companies\nnước việt nam hiện tại có rất nhiều hãng xe taxi","transport"));

        mData.child("Transport").setValue(arrayListTransport);

        imgCLOSETHEME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCloseTheme = new Intent(Practice_Vocabulary_Activity.this, HomeActivity.class);
                startActivity(intentCloseTheme);
            }
        });


        // TỘC 1
        ArrayList<mdQuestion> arrayQuestion = new ArrayList<mdQuestion>();
        ArrayList<String> arrayAnswer = new ArrayList<String>();
        arrayAnswer.add("Bee");
        arrayAnswer.add("Bird");
        arrayAnswer.add("Buffalo");
        arrayAnswer.add("Buttefly");
        ArrayList<String> arrayAnswer1 = new ArrayList<String>();
        arrayAnswer1.add("Cat");
        arrayAnswer1.add("Chicken");
        arrayAnswer1.add("Dinosaur");
        arrayAnswer1.add("Dog");
        ArrayList<String> arrayAnswer2 = new ArrayList<String>();
        arrayAnswer1.add("Dinosaur");
        arrayAnswer1.add("Dog");
        arrayAnswer2.add("Fish");
        arrayAnswer2.add("Pig");
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bee_resize.jpg?alt=media&token=9e2f1044-b097-41ba-9fb6-d610445a8177","Hãy chọn đáp án đúng",arrayAnswer,"Bee"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bird_resize.jpg?alt=media&token=99c8b86e-6b05-4ef2-ad80-540a24870303","Hãy chọn đáp án đúng",arrayAnswer,"Bird"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/buffalo_resize.jpg?alt=media&token=c74e9310-edff-4b1c-b19c-9da96166590a","Hãy chọn đáp án đúng",arrayAnswer,"Buffalo"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/buttefly_resize.jpg?alt=media&token=a54b0811-32ae-40db-96af-1436ce5e738f","Hãy chọn đáp án đúng",arrayAnswer,"Buttefly"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cat.jpg?alt=media&token=d14be30a-9fc4-4c98-94d2-24c3258d325f","Hãy chọn đáp án đúng",arrayAnswer1,"Cat"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/chicken.jpg?alt=media&token=29e6584b-1a18-4543-8397-189bef7f48b1","Hãy chọn đáp án đúng",arrayAnswer1,"Chicken"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dinosaur.jpg?alt=media&token=a7f70444-b145-41e3-b835-1f201ef49372","Hãy chọn đáp án đúng",arrayAnswer1,"Dinosaur"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/dog.jpg?alt=media&token=2018fdd4-8b4e-4689-9260-c927f5b8c57a","Hãy chọn đáp án đúng",arrayAnswer1,"Dog"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/fish.jpg?alt=media&token=e58b4150-75d9-4abe-abd7-96f9cd5a3420","Hãy chọn đáp án đúng",arrayAnswer2,"Fish"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pig.jpg?alt=media&token=c785d0f9-c114-4dd1-93f9-5ab2c3e60e57","Hãy chọn đáp án đúng",arrayAnswer2,"Pig"));

        // TỘC 2
        ArrayList<String> arrayAnswer4 = new ArrayList<String>();
        arrayAnswer4.add("Teacher");
        arrayAnswer4.add("School");
        arrayAnswer4.add("Subject");
        arrayAnswer4.add("School bag");
        ArrayList<String> arrayAnswer5 = new ArrayList<String>();
        arrayAnswer5.add("Physical education");
        arrayAnswer5.add("Pencil sharpener");
        arrayAnswer5.add("Librarian");
        arrayAnswer5.add("Homework");
        ArrayList<String> arrayAnswer6 = new ArrayList<String>();
        arrayAnswer6.add("Exam");
        arrayAnswer6.add("Class president");
        arrayAnswer6.add("Homework");
        arrayAnswer6.add("Subject");

        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/teacher.jpg?alt=media&token=08ab117b-99bb-49b3-ac1e-e9386f327182","Hãy chọn đáp án đúng",arrayAnswer4,"Teacher"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/school.jpg?alt=media&token=de584b14-1e28-4627-b2ea-ba2f1d8dd815","Hãy chọn đáp án đúng",arrayAnswer4,"School"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subject.jpg?alt=media&token=5d4b8539-c3a8-4a45-a691-3bc53cd0e624","Hãy chọn đáp án đúng",arrayAnswer4,"Subject"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/school%20bag.jpg?alt=media&token=225f72cc-5bd7-4683-96af-9c0493f89a06","Hãy chọn đáp án đúng",arrayAnswer4,"School bag"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/physical%20education.jpg?alt=media&token=e155647a-3f4c-4b4b-b6a8-f1754e051f44","Hãy chọn đáp án đúng",arrayAnswer5,"Physical education"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pencil%20sharpener.jpg?alt=media&token=1bd313a2-e468-44d3-aac7-5b3d1352ba39","Hãy chọn đáp án đúng",arrayAnswer5,"Pencil sharpener"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/librarian.jpg?alt=media&token=302f79c4-6076-46b5-a51e-20d910b6d150","Hãy chọn đáp án đúng",arrayAnswer5,"Librarian"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/homework.jpg?alt=media&token=48a0e462-ebee-48fd-96d5-e1e977cdace4","Hãy chọn đáp án đúng",arrayAnswer5,"Homework"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/exam_.jpg?alt=media&token=55dd2b0a-116d-4c0b-8dad-ba88e2f36cd1","Hãy chọn đáp án đúng",arrayAnswer6,"Exam"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/class%20president.jpg?alt=media&token=6283d971-391c-40e3-8ba8-2f26a9a234da","Hãy chọn đáp án đúng",arrayAnswer6,"Class president"));

        // TỘC 3

        ArrayList<String> arrayAnswer7 = new ArrayList<String>();
        arrayAnswer7.add("Air-condition");
        arrayAnswer7.add("Bed");
        arrayAnswer7.add("Blanket");
        arrayAnswer7.add("Bookshelf");
        ArrayList<String> arrayAnswer8 = new ArrayList<String>();
        arrayAnswer8.add("Chair");
        arrayAnswer8.add("Clock");
        arrayAnswer8.add("Computer");
        arrayAnswer8.add("Fan");
        ArrayList<String> arrayAnswer9 = new ArrayList<String>();
        arrayAnswer9.add("Pillow");
        arrayAnswer9.add("Television");
        arrayAnswer9.add("Clock");
        arrayAnswer9.add("Fan");

        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/air-condition.jpg?alt=media&token=f3bca591-58f1-4822-9cae-c41ee0edab5a","Hãy chọn đáp án đúng",arrayAnswer7,"Air-condition"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bed.jpg?alt=media&token=979aedf8-d71b-4c86-a898-11e050d9067c","Hãy chọn đáp án đúng",arrayAnswer7,"Bed"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/blanket.jpg?alt=media&token=cc270b4b-4f49-4336-9765-1b3baeb33e2e","Hãy chọn đáp án đúng",arrayAnswer7,"Blanket"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bookshelf.jpg?alt=media&token=239e5233-f21c-48ad-8d17-2f94f3eeb356","Hãy chọn đáp án đúng",arrayAnswer7,"Bookshelf"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/chair.jpg?alt=media&token=149dcfe1-d19d-48b4-8013-37d127d2797e","Hãy chọn đáp án đúng",arrayAnswer8,"Chair"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/clock.jpg?alt=media&token=447de619-6b96-4b86-acc9-ea0bbefec35a","Hãy chọn đáp án đúng",arrayAnswer8,"Clock"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/computer.jpg?alt=media&token=32e718eb-18f1-4af3-b4ef-846457f80bc3","Hãy chọn đáp án đúng",arrayAnswer8,"Computer"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/fan.jpg?alt=media&token=f899d701-1107-4c28-a19e-c44163aab4fe","Hãy chọn đáp án đúng",arrayAnswer8,"Fan"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/pillow.jpg?alt=media&token=16074bd8-af61-4c9a-8ee1-c5686e8308b3","Hãy chọn đáp án đúng",arrayAnswer8,"Pillow"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/television.jpg?alt=media&token=37585606-87e5-482a-85ee-ff76b83d0302","Hãy chọn đáp án đúng",arrayAnswer8,"Television"));

        // TỘC 4
        ArrayList<String> arrayAnswer10 = new ArrayList<String>();
        arrayAnswer10.add("Japan");
        arrayAnswer10.add("England");
        arrayAnswer10.add("India");
        arrayAnswer10.add("Singapore");
        ArrayList<String> arrayAnswer11 = new ArrayList<String>();
        arrayAnswer11.add("Combodia");
        arrayAnswer11.add("America");
        arrayAnswer11.add("Canada");
        arrayAnswer11.add("Denmark");
        ArrayList<String> arrayAnswer12 = new ArrayList<String>();
        arrayAnswer12.add("Australia");
        arrayAnswer12.add("Russia");
        arrayAnswer12.add("Denmark");
        arrayAnswer12.add("England");

        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Japan.png?alt=media&token=428d77de-4ce9-4b8e-a86b-b55829304080","Hãy chọn đáp án đúng",arrayAnswer10,"Japan"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ANh.png?alt=media&token=e7c30363-e10f-49e3-90ec-9723226ac30b","Hãy chọn đáp án đúng",arrayAnswer10,"England"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/ando.png?alt=media&token=e2bf0d84-d913-414a-bcd4-8084892ac090","Hãy chọn đáp án đúng",arrayAnswer10,"India"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/singapore.png?alt=media&token=6ec0f50b-360b-418a-a7b4-a3bd64b98ed2","Hãy chọn đáp án đúng",arrayAnswer10,"Singapore"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/cambodia.png?alt=media&token=7e6c7fae-2850-4df5-90e6-fb727fad6af0","Hãy chọn đáp án đúng",arrayAnswer11,"Combodia"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/My.png?alt=media&token=4bd46de6-d8c0-4e06-97e6-1e76e0506d86","Hãy chọn đáp án đúng",arrayAnswer11,"America"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/canada.png?alt=media&token=e2495e65-fd25-4077-bc91-0d2a54af8ca6","Hãy chọn đáp án đúng",arrayAnswer11,"Canada"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/DanMach.png?alt=media&token=d1775e9b-45a8-4597-98cd-85e4acfc5ce4","Hãy chọn đáp án đúng",arrayAnswer11,"Denmark"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Uc.png?alt=media&token=a49e0d93-7e00-4a5f-9663-fc2b9502d83e","Hãy chọn đáp án đúng",arrayAnswer12,"Australia"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/Nga.png?alt=media&token=9a42e6d0-8e5f-464b-89dd-a38ac7efa85a","Hãy chọn đáp án đúng",arrayAnswer12,"Russia"));


        // TỘC 5

        ArrayList<String> arrayAnswer13 = new ArrayList<String>();
        arrayAnswer13.add("Bus");
        arrayAnswer13.add("Car");
        arrayAnswer13.add("Bicycle");
        arrayAnswer13.add("Truck");
        ArrayList<String> arrayAnswer14 = new ArrayList<String>();
        arrayAnswer14.add("Scrooter");
        arrayAnswer14.add("Train");
        arrayAnswer14.add("Subway");
        arrayAnswer14.add("Motorbike");
        ArrayList<String> arrayAnswer15 = new ArrayList<String>();
        arrayAnswer15.add("Ambulance");
        arrayAnswer15.add("Taxi");
        arrayAnswer15.add("Motorbike");
        arrayAnswer15.add("Subway");

        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bus.jpg?alt=media&token=593abfe9-af76-4162-b458-17b1c186020a","Hãy chọn đáp án đúng",arrayAnswer13,"Bus"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/car.jpg?alt=media&token=4457479f-1376-4df5-8390-ce6a5161f76d","Hãy chọn đáp án đúng",arrayAnswer13,"Car"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/bicycle.jpg?alt=media&token=0da8b373-d289-4032-98ce-e99a11f895cd","Hãy chọn đáp án đúng",arrayAnswer13,"Bicycle"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/truck.jpg?alt=media&token=f7b26961-d5f6-4ad5-ac17-00cef893ff3e","Hãy chọn đáp án đúng",arrayAnswer13,"Truck"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/scrooter.jpg?alt=media&token=4249b071-4fa7-4b89-8d34-64dc603fccb4","Hãy chọn đáp án đúng",arrayAnswer14,"Scrooter"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/train.mp3?alt=media&token=a1b146bd-c277-4e0f-b443-ab1f403fbec1","Hãy chọn đáp án đúng",arrayAnswer14,"Train"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/subway.jpg?alt=media&token=e266d141-8fec-46f6-b380-c67113bf7379","Hãy chọn đáp án đúng",arrayAnswer14,"Subway"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/motorbike.jpg?alt=media&token=ff0ec710-22d1-4d5c-b7a8-6ad04c7bfab4","Hãy chọn đáp án đúng",arrayAnswer14,"Motorbike"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/xe%20cap%20cuu.jpg?alt=media&token=f0297fcb-a842-47ad-83f8-c5c0dc97ff02","Hãy chọn đáp án đúng",arrayAnswer15,"Ambulance"));
        arrayQuestion.add(new mdQuestion("https://firebasestorage.googleapis.com/v0/b/appchatver.appspot.com/o/taxi.jpg?alt=media&token=72645729-6498-4ced-9201-d724ab26b7fb","Hãy chọn đáp án đúng",arrayAnswer15,"Taxi"));

        mData.child("Question").setValue(arrayQuestion);*/

        closeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCloseThemeLearn = new Intent(Practice_Vocabulary_Activity.this,HomeActivity.class);
                startActivity(intentCloseThemeLearn);
            }
        });

        // Animal
        btn_Animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice_Vocabulary_Activity.this, Theme_Animal.class);
                Bundle bundle = new Bundle();
                bundle.putString("theme_all", "animal");
                myIntent.putExtra("bundle", bundle);
                startActivity(myIntent);
            }
        });

        // Study
        btn_Study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice_Vocabulary_Activity.this, Theme_Animal.class);
                Bundle bundle = new Bundle();
                bundle.putString("theme_all", "study");
                myIntent.putExtra("bundle", bundle);
                startActivity(myIntent);
            }
        });

        // Family
        btn_Family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice_Vocabulary_Activity.this, Theme_Animal.class);
                Bundle bundle = new Bundle();
                bundle.putString("theme_all", "family");
                myIntent.putExtra("bundle", bundle);
                startActivity(myIntent);
            }
        });

        // Object
        btn_Object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice_Vocabulary_Activity.this, Theme_Animal.class);
                Bundle bundle = new Bundle();
                bundle.putString("theme_all", "object");
                myIntent.putExtra("bundle", bundle);
                startActivity(myIntent);
            }
        });

        // Country
        btn_Country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice_Vocabulary_Activity.this, Theme_Animal.class);
                Bundle bundle = new Bundle();
                bundle.putString("theme_all", "country");
                myIntent.putExtra("bundle", bundle);
                startActivity(myIntent);
            }
        });

        // Transport
        btn_Transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice_Vocabulary_Activity.this, Theme_Animal.class);
                Bundle bundle = new Bundle();
                bundle.putString("theme_all", "transport");
                myIntent.putExtra("bundle", bundle);
                startActivity(myIntent);
            }
        });
    }

    private void initView() {
        imgCLOSETHEME = (ImageView) findViewById(R.id.closeTheme);
        btn_Animal = (LinearLayout) findViewById(R.id.btn_Animal);
        btn_Study = (LinearLayout) findViewById(R.id.btn_Study);
        btn_Family = (LinearLayout) findViewById(R.id.btn_Family);
        btn_Object = (LinearLayout) findViewById(R.id.btn_Object);
        btn_Country = (LinearLayout) findViewById(R.id.btn_Country);
        btn_Transport = (LinearLayout) findViewById(R.id.btn_Transport);
        closeTheme = (ImageView) findViewById(R.id.closeTheme);
    }
}
