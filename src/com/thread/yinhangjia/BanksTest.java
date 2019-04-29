package com.thread.yinhangjia;
import java.util.Arrays;

public class BanksTest {
    // ���ڴ洢Ԥ���������Դ�仯
    static int[] new_Avaliable = null;
    // ���ڴ洢Ԥ��������ɶ�
    static boolean[] new_finish = null;
    // ���ڱ������յĽ���ִ��˳��,��ʼ��Ϊ�Ƿ�����-1
    static int right[] = { -1, -1, -1, -1, -1 };

    public static void main(String[] args) {
        // ���������
        int[][] max = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 }, { 4, 3, 3 } };
        // ��ǰϵͳ������Դ��
        int[] avaliable = { 3, 3, 2 };
        // ÿ���������л�����Դ��
        int[][] need = new int[5][3];
        // ÿ�������ѷ������Դ��
        int[][] allocation = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 }, { 0, 0, 2 } };
        // ���ڵ�һ���Ԥ�еĳ�ʼ��
        boolean finish[] = { false, false, false, false, false };
        // ��ȡÿ����������ʱ�������Դ��
        for (int i = 0; i < max.length; i++) {
            for (int j = 0; j < max[i].length; j++) {
                need[i][j] = max[i][j] - allocation [i][j]; //�����ÿһ�����̶���j��Դ�Ļ���Ҫ��������
            }
        }
        // �����ݹ����
        int deep = 0;
        // ���û��ݵݹ��㷨
        deepCheck(avaliable, allocation, need, finish, deep, right);
        int i = 0;
        
        // �鿴���յİ�ȫ���е�ֵ�����Ƿ���ڳ�ʼ�ķǷ����̣�������ڣ���˵���ð��������ڰ�ȫ�Ľ���ִ��˳��
        for (; i < right.length; i++) {
            if (right[i] == -1) {
                break;
            }
        }
        
        if (i < right.length) {
            System.out.println("�ð��������ڰ�ȫ�Ľ���ִ��˳��");
            return;
        }
        
        // ��ӡ��ȫ��ִ��˳��
        for (int j = 0; j < right.length; j++) {
            System.out.println(right[j]);
        }

    }

    // ��ȫ�ݹ���ݲ��Ұ�ȫ˳��
    public static boolean deepCheck(int[] avaliable, int[][] allocation, int[][] need, boolean finish[], int deep,
            int right[]) {
        int j = 0;
        boolean flog = false;
        // ������Ϊ���̵ĸ�����˵���Ѿ����ҵ�ͷ��,˵����һ��ȵĽ����ǰ�ȫ�ڵ㡣��Ϊ��һ��ȵĽ��������˵�ǰ��Դ�����ڻ���ڸý��������������Դ������Ϊ��ȫ���������һ���ڵ㡣
        if (deep == need.length) {
            return true;
        }
        // �������нڵ���̿�ʼ����,ֱ���ҵ���ȫУ��ɹ��ĵĽڵ����
        for (int i = 0; i < need.length; i++) {
            // ����δ����ǵĽ���У�飬�ѱ���ǵ�Ϊ�ѱ���Ϊ��ȫ�ڵ����������ٽ���У��
            if (!finish[i]) {
                // �жϵ�ǰ�Ľڵ���̵�ʣ�����Դ��,�Ƿ����������������Դ��
                for (j = 0; j < avaliable.length; j++) {
                    // ������
                    if (need[i][j] > avaliable[j]) {
                        break;
                    }
                }
                // ������������һ���ڵ����
                if (j < avaliable.length) {
                    continue;
                } else {
                    // �������
                    // ���ƻᱻ�޸ĵ�ǰ���������ѱ��ڵ�ǰ����У�鲻�ɹ�ʱ�����Իָ�ǰ����������ʼ��һ���ڵ���̵�У��
                    new_Avaliable = Arrays.copyOf(avaliable, avaliable.length);
                    new_finish = Arrays.copyOf(finish, finish.length);
                    // ���赱ǰ�ڵ�����ǿ���У��ɹ��Ľڵ���̣��޸ĸý���������Ϻ��ͷ�֮ǰ����Ľ��̡�
                    for (j = 0; j < new_Avaliable.length; j++) {
                        new_Avaliable[j] += allocation[i][j];
                    }
                    // �����ǵ�ǰΪУ��ɹ��İ�ȫ�ڵ���̣���һ��Ȳ���ʱ����Դ˽��̡�
                    new_finish[i] = true;
                    // �������
                    deep++;
                    // ���ϼ���Ϊǰ�ᣬ������һ��ȵİ�ȫУ���ж�������ʣ������Ƿ���Լ������У��������������
                    flog = deepCheck(new_Avaliable, allocation, need, new_finish, deep, right);
                    // ������а�ȫУ���Ϊ�棬˵����ǰ����������Ҫ�ҵĽ���
                    if (flog) {
                        // ���浽���ս���ִ�����е�������
                        right[--deep] = i;
                        break;
                    }

                }

            }

        }
        // ��ȫУ��ɹ�
        if (flog) {
            return true;
        } else {
            // ��ȫУ��ʧ��
            // ���֮ǰ�ļ�����
            new_finish[right[--deep]] = false;
            return false;
        }

    }
}