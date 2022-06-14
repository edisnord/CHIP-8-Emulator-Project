package chip;

public class Memory {
    /**
     * 4kB of 8-bit memory<br/>
     * At position 0x50: The "bios" fontset
     * At position 0x200: The start of every program
     */
    public char[] RAM;

    /**
     * 16 8-bit registers.<br/>
     * Register 0xF is used for Carry, Borrow and collision detection
     */
    public char[] V;

    public Memory(){
        RAM = new char[4096];
        V = new char[16];
        loadFontset();
    }

    /**
     * Loads the fontset into the memory
     */
    public void loadFontset() {
        for (int i = 0; i < fontset.length; i++) {
            RAM[0x50 + i] = (char) (fontset[i] & 0xFF);
        }
    }

    public static int[] fontset =
            {
                    0xF0, 0x90, 0x90, 0x90, 0xF0, // 0
                    0x20, 0x60, 0x20, 0x20, 0x70, // 1
                    0xF0, 0x10, 0xF0, 0x80, 0xF0, // 2
                    0xF0, 0x10, 0xF0, 0x10, 0xF0, // 3
                    0x90, 0x90, 0xF0, 0x10, 0x10, // 4
                    0xF0, 0x80, 0xF0, 0x10, 0xF0, // 5
                    0xF0, 0x80, 0xF0, 0x90, 0xF0, // 6
                    0xF0, 0x10, 0x20, 0x40, 0x40, // 7
                    0xF0, 0x90, 0xF0, 0x90, 0xF0, // 8
                    0xF0, 0x90, 0xF0, 0x10, 0xF0, // 9
                    0xF0, 0x90, 0xF0, 0x90, 0x90, // A
                    0xE0, 0x90, 0xE0, 0x90, 0xE0, // B
                    0xF0, 0x80, 0x80, 0x80, 0xF0, // C
                    0xE0, 0x90, 0x90, 0x90, 0xE0, // D
                    0xF0, 0x80, 0xF0, 0x80, 0xF0, // E
                    0xF0, 0x80, 0xF0, 0x80, 0x80  // F
            };

}