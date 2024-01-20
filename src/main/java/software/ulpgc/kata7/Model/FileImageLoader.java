package software.ulpgc.kata7.Model;

import java.io.File;
import java.io.FileFilter;

public class FileImageLoader implements ImageLoader {

    private final File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(isImage());
    }

    private FileFilter isImage() {
        return (File pathname) -> pathname.getName().endsWith(".png") || pathname.getName().endsWith(".jpg");
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                assert files != null;
                return files[i].getPath();
            }

            @Override
            public Image next() {
                assert files != null;
                return imageAt((i + 1) % files.length);
            }

            @Override
            public Image prev() {
                assert files != null;
                return imageAt(i > 0 ? i -1 : files.length-1);
            }
        };
    }
}
