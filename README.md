LoopPagerAdapter
========

n개의 화면의 앞과 뒤를 연결하여 계속 반복되는 ViewPager를 만들기 위해 만들어진 추상클래스 라이브러리입니다.

<b>app</b> 폴더의 프로젝트는 LoopPagerAdapter를 사용한 ViewPager 예제입니다.

다운받은 후<br/>
위에 보이는 <b>looppageradapter</b> 폴더만 따로<br/>Android Studio의 메뉴 File > new > Import Project... 하거나<br/><br/>
<b>looppageradapter/build/outputs/aar/looppageradapter-release.aar</b> 파일을<br/>Android Studio의 메뉴 File > new > Import Module... 하세요.

사용법 
------
ViewPager에 적용시킬 Adapte를 구현합니다.
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

ViewPager에 적용시 다음과 같이 적용합니다.
```java
ViewPager vp = (ViewPager)findViewById(R.id.viewpager1);
DemoPagerAdapter adapter = new DemoPagerAdapter(vp,arr);
adapter.ready(); 
//ready를 호춣해야 setAdaapter 및 처음 화면과 addOnPageChangeListener를 통한 올바른 무한 루프 화면이 구성됩니다.
```
