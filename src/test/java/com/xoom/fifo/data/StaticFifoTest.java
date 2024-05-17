package com.xoom.fifo.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StaticFifoTest {

    @Test
    void test() {
        var array = new StaticFifo<Integer>();

        array.print();
        array.push(123);
        array.print();
    }

    @Test
    void countIsEmpty() {

        var array = new StaticFifo<Integer>();

        assertThat(array.isEmpty())
                .isTrue();

        array.push(123);
        array.push(1);
        array.push(3);

        assertThat(array.isEmpty())
                .isFalse();

        assertThat(array.count())
                .isEqualTo(3);
    }

    @Test
    void pushPop() {

        var array = new StaticFifo<String>();

        assertThat(array.isEmpty())
                .isTrue();

        array.push("123");
        array.push("1");
        array.push("3");

        assertThat(array.count())
                .isEqualTo(3);

        array.print();

        assertThat(array.pop())
                .isEqualTo("123");

        array.print();

        assertThat(array.pop())
                .isEqualTo("1");

        assertThat(array.pop())
                .isEqualTo("3");

        array.print();

        array.push("hola mundo");

        array.print();

        assertThat(array.pop())
                .isEqualTo("hola mundo");

        assertThatThrownBy(array::pop)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Array is empty");
    }

    @Test
    void testObjects() {

        var array = new StaticFifo<TestData>();

        array.push(new TestData("Hervert", 47));
        array.push(new TestData("Francisco", 44));

        array.print();

        var item  = array.pop();

        System.out.println(item);

        array.print();
    }


    static class TestData {

        private String name;
        private int age;

        public TestData(String name, int age) {

            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
