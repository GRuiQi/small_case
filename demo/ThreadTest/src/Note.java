public class Note {
    public static void main(String[] args) {
        /**
         * 1.底层研发，负责基础设施（例如消息队列）研发。会用到多线程
         * 2.考察学习，理解能力。
         *    面试大概率会考察多线程。这已经是公开的秘密了。
         *    对后又的候选人是公平的，比拼的是候选人的学习能力，理解能力，做事调度
         *    可以没用过，但是要有快速掌握的能力，和稳扎稳打的学习态度
         *
         *    回答多线程问题时，为什么有人对答如流，有的人答非所问？
         *    1. 对面试准备的态度。明知道要考察多线程，候选人却不认真准备，这种
         *    态度带到工作中是何其的可怕。
         *    2.学习能力。短时间內掌握平时不常用到的多线程并不容易，彻底理解
         *    多线程还需要掌握JVM的知识
         *
         *    软件架构可以看作现实世界工厂里的机器设计和布置。我们需要考虑很多，比如需要哪些机器，不同机器如何配比、
         *    不同工序之间如何衔接、机器出问题如何应对、机器操作日志如何记录、安全如何保障。工厂里遇到的问题在软件
         *    架构上也都会遇到。
         */

        /**
         * 多线程使用场景：
         * 如果程序需要重复执行一段逻辑，每次执行又互不影响，那么你可以考虑采用多线程，
         * 每个线程执行任务总量的一部分，最后再把每个线程执行的结果合并。通过并行处理，
         * 能够大大减少执行时间。Java 8 开始出现的 lambda 并行流，
         * 就是采用的这种思想，只不过它是 JVM 去实现，而不需要我们做额外的处理。
         */
    }
}
