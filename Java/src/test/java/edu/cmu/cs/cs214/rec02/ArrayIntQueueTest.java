package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ArrayIntQueueTest {

    private IntQueue mQueue;
    @Before
    public void setUp() {
    mQueue = new ArrayIntQueue(); // ArrayIntQueue ашиглах
    }

    @Test
public void testClear() {
    // Эхлээд queue-ийг хэд хэдэн элементийн хамт enqueue хийнэ
    mQueue.enqueue(10);
    mQueue.enqueue(20);
    mQueue.enqueue(30);

    // Queue нь хоосон биш гэдгийг шалгая
    assertFalse(mQueue.isEmpty());
    assertEquals(3, mQueue.size()); // size нь 3 байх ёстой

    // clear() функцийн дараа queue нь хоосон байх ёстой
    mQueue.clear();

    // Queue нь хоосон болсон байх ёстой
    assertFalse(mQueue.isEmpty());
    assertEquals(0, mQueue.size()); // size нь 0 байх ёстой
    assertNull(mQueue.peek()); // peek() нь null буцах ёстой
}


    @Test
    public void testIsEmpty() {
        ArrayIntQueue queue = new ArrayIntQueue();
        assertTrue(queue.isEmpty()); // ✅ Одоо зөв ажиллах ёстой
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testPeek() {
    ArrayIntQueue queue = new ArrayIntQueue();
    assertNull(queue.peek()); // ✅ Одоо null буцах ёстой
    queue.enqueue(5);
    assertEquals((Integer) 5, queue.peek()); // test дээр queue ашиглаж байна
    }

    @Test
    public void testEnsureCapacity() {
        ArrayIntQueue queue = new ArrayIntQueue();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        assertEquals(15, queue.size()); // ✅ EnsureCapacity зөв ажиллаж байгааг шалгах
    }

    @Test
    public void testDequeue() {
        mQueue.enqueue(1);
        mQueue.enqueue(2);
        mQueue.enqueue(3);

        assertEquals((Integer) 1, mQueue.dequeue());
        assertEquals((Integer) 2, mQueue.dequeue());
        assertEquals((Integer) 3, mQueue.dequeue());
        assertNull(mQueue.dequeue());
    }
}

