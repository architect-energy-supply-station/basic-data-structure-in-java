package operation;

/**
 * @author bill-smith liuwb
 * @Package operation
 * @Date 2019/12/20 12:17
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class PlusEqualsDiffEqualsPlus{
    public static void main(String[] args) {
        TestGenetic testGenetic = new TestGenetic();
        Person linda = new Person("linda", "women");
        testGenetic.plusEqualsTest(2147483648L);
        testGenetic.plusEqualsTest(2147483646);
        testGenetic.plusEqualsTest("123");
        testGenetic.plusEqualsTest(linda);
        int[] arr = {12,22,33};
        testGenetic.plusEqualsTest(arr);
    }
}
class TestGenetic<T>{

    void plusEqualsTest(T t) {
//        System.out.println("test genetic");
        if (t instanceof int[]) {
            int[] temp = (int[]) t;
            for (int i = 0; i <temp.length; i++) {
                System.out.println(temp[i]);
            }
            return;
        }
        System.out.println(t);
    }
}

class Person{
    String name;
    String sex;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Peoson{");
        sb.append("name='").append(name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
