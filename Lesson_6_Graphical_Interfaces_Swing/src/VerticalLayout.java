import java.awt.*;

public class VerticalLayout implements LayoutManager {

    private Dimension size = new Dimension();

    //Эти 2 метода не используем
    @Override
    public void addLayoutComponent(String s, Component component) {

    }

    @Override
    public void removeLayoutComponent(Component component) {

    }

    /**
     * Метод определения предпочтительного размера для контейнера
     */
    @Override
    public Dimension preferredLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    @Override
    /**
     * Метод определения минимального размера для контейнера
     */
    public Dimension minimumLayoutSize(Container c) {
        return calculateBestSize(c);
    }


    /**
     * Метод расположения элементов в контейнере
     */
    @Override
    public void layoutContainer(Container container) {
        //Список компонентов
        Component[] list = container.getComponents();
        int currentY = 5;
        for (int i = 0; i < list.length; i++) {

            //Определение предпочтительного размера компонента
            Dimension pref = list[i].getPreferredSize();

            //Размещение компонента на экране
            list[i].setBounds(5, currentY, pref.width, pref.height);

            //Учитываем промежуток в 5 пикселов
            currentY += 5;

            //Смещаем вертикальную позицию компонента
            currentY += pref.height;
        }
    }

    private Dimension calculateBestSize (Container c){

        //Вычислим длину контейнера
        Component[] list = c.getComponents();
        int maxWidth = 0;
        for (int i = 0; i < list.length ; i++) {
            int width = list[i].getWidth();
            //Поиск компонента с максимальной длинной
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        //размер контейнера в длину с учетом левого отступа
        size.width = maxWidth + 5;

        //Вычисляем высоту контейнера
        int height = 0;
        for (int i = 0; i < list.length ; i++) {
            height += 5;
            height += list[i].getHeight();
        }

        size.height = height;

        return size;
    }
}
