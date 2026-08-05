package com.游戏;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

// 主游戏类，继承JFrame并实现监听器
public class SnackGame extends JFrame implements KeyListener, ActionListener {
    private final int BLOCK_SIZE = 20;  // 每个方块的大小
    private final int GAME_WIDTH = 400; // 游戏窗口宽度
    private final int GAME_HEIGHT = 400;// 游戏窗口高度
    private final int ALL_BLOCKS = (GAME_WIDTH * GAME_HEIGHT) / (BLOCK_SIZE * BLOCK_SIZE);

    private ArrayList<Point> snake;     // 存储蛇的身体坐标
    private Point food;                 // 食物坐标
    private char direction = 'R';       // 蛇的移动方向：U上 D下 L左 R右
    private boolean isRunning = false;  // 游戏运行状态
    private Timer timer;                // 控制游戏帧率
    private int score = 0;              // 游戏分数

    public SnackGame() {
        // 窗口初始化
        setTitle("Java 贪吃蛇");
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);

        // 初始化游戏
        initGame();

        // 定时器：每150毫秒触发一次动作
        timer = new Timer(150, this);
        timer.start();
    }

    // 初始化游戏数据
    private void initGame() {
        snake = new ArrayList<>();
        // 初始化蛇头和两节身体
        snake.add(new Point(100, 100));
        snake.add(new Point(80, 100));
        snake.add(new Point(60, 100));
        generateFood(); // 生成食物
        isRunning = true;
        score = 0;
    }

    // 随机生成食物
    private void generateFood() {
        Random random = new Random();
        int x = random.nextInt((GAME_WIDTH - BLOCK_SIZE) / BLOCK_SIZE) * BLOCK_SIZE;
        int y = random.nextInt((GAME_HEIGHT - BLOCK_SIZE) / BLOCK_SIZE) * BLOCK_SIZE;
        food = new Point(x, y);
        // 防止食物生成在蛇身上
        if (snake.contains(food)) {
            generateFood();
        }
    }

    // 绘制游戏界面
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // 绘制游戏背景
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        if (isRunning) {
            // 绘制食物
            g2d.setColor(Color.RED);
            g2d.fillRect(food.x, food.y, BLOCK_SIZE, BLOCK_SIZE);

            // 绘制蛇
            for (Point p : snake) {
                g2d.setColor(Color.GREEN);
                g2d.fillRect(p.x, p.y, BLOCK_SIZE, BLOCK_SIZE);
                // 蛇身体边框
                g2d.setColor(Color.WHITE);
                g2d.drawRect(p.x, p.y, BLOCK_SIZE, BLOCK_SIZE);
            }

            // 绘制分数
            g2d.setColor(Color.WHITE);
            g2d.drawString("分数: " + score, 10, 20);
        } else {
            // 游戏结束界面
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("游戏结束! 分数: " + score, 100, 200);
            g2d.drawString("按空格键重新开始", 80, 230);
        }
    }

    // 蛇的移动逻辑
    private void moveSnake() {
        Point head = snake.get(0);
        Point newHead = new Point(head);

        // 根据方向移动蛇头
        /*switch (direction) {
            case 'U' -> newHead.y -= BLOCK_SIZE;
            case 'D' -> newHead.y += BLOCK_SIZE;
            case 'L' -> newHead.x -= BLOCK_SIZE;
            case 'R' -> newHead.x += BLOCK_SIZE;
        }*/

        // 添加新蛇头
        snake.add(0, newHead);

        // 判断是否吃到食物
        if (newHead.equals(food)) {
            score += 10;
            generateFood();
        } else {
            // 没吃到食物则移除尾部
            snake.remove(snake.size() - 1);
        }

        // 碰撞检测：撞墙或撞自己
        if (newHead.x < 0 || newHead.x >= GAME_WIDTH || newHead.y < 0 || newHead.y >= GAME_HEIGHT || snake.subList(1, snake.size()).contains(newHead)) {
            isRunning = false;
        }
    }

    // 键盘事件监听：控制方向和重启
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        /*switch (key) {
            case KeyEvent.VK_UP -> { if (direction != 'D') direction = 'U'; }
            case KeyEvent.VK_DOWN -> { if (direction != 'U') direction = 'D'; }
            case KeyEvent.VK_LEFT -> { if (direction != 'R') direction = 'L'; }
            case KeyEvent.VK_RIGHT -> { if (direction != 'L') direction = 'R'; }
            case KeyEvent.VK_SPACE -> { if (!isRunning) initGame(); }
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            moveSnake();
        }
        repaint(); // 重绘界面
    }

    // 未使用的接口方法
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    // 主方法：启动游戏
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnackGame().setVisible(true));
    }
}
