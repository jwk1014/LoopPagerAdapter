LoopPagerAdapter
========

N개의 화면의 앞과 뒤를 연결하여 <b>계속 반복되는 ViewPager</b>를 만들기 위해 만들어진 추상클래스 라이브러리입니다.

<b>app</b> 폴더의 프로젝트는 <b>LoopPagerAdapter</b>를 사용한 ViewPager 예제입니다.<br/>
<b>looppageradapter</b> 폴더의 프로젝트는 <b>LoopPagerAdapter</b>를 사용한 ViewPager 예제입니다.

Import
------
위 프로젝트를 다운받은 후<br/>
Android Studio의 메뉴 File > new > Import Module... 를 선택<br/>
<b>looppageradapter</b> 폴더를 선택하여 추가하세요.<br/>
app 수준의 build.gradle 파일의 dependencies에 아래와 같은 구문을 추가하세요.<br/>
<pre><code>compile project(':looppageradapter')</code></pre><br/>
사용법 
------
ViewPager에 적용시킬 Adapter를 구현합니다.
(아래 내용은 예제입니다.)
```java
public class DemoPagerAdapter extends LoopPagerAdapter {
    private List<String> arr;

    public DemoPagerAdapter(ViewPager viewPager, List<String> arr){
        super(viewPager);
        this.arr = arr;
    }

    @Override
    public Object getItem(int position) { //position번째 화면을 그리는데 필요한 아이템 
        return arr.get(position);
    }

    @Override
    public int getItemCount() { //화면 개수 
        return arr.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.page_content,container,false);

        ((TextView)v.findViewById(R.id.page_content_textview1)).setText( (String)getLoopItem(position) );
        //getLoopItem으로 아이템을 얻어야 화면에 맞는 올바른 아이템을 얻을 수 있습니다.
    
        container.addView(v);

        return v;
    }
}
```

ViewPager에 Adapter를 적용 시 다음과 같은 방법으로 적용합니다.
```java
ViewPager vp = (ViewPager)findViewById(R.id.viewpager1);
DemoPagerAdapter adapter = new DemoPagerAdapter(vp,arr);
adapter.ready(); 
//ready를 호춣해야 setAdaapter 및 처음 화면과 addOnPageChangeListener를 통한 올바른 무한 루프 화면이 구성됩니다.
```
