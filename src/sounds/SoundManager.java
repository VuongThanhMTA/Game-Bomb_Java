package sounds;


/**
 * Created by T on 8/17/2016.
 */
public class SoundManager {
    private SourceEffect soundBackground;


    private SourceEffect soundStart;
    private SourceEffect soundSetBomb;
    private SourceEffect soundBomBang;
    private SourceEffect soundMonster;
    private SourceEffect soundItem;
    private SourceEffect soundBomberDie;
    private SourceEffect soundBye;
    private SourceEffect soundTouch;
    private SourceEffect soundClick;


    public SoundManager() {
        soundBackground = new SourceEffect("background.wav");

    }

    public SourceEffect getSoundClick() {
        return soundClick = new SourceEffect("click.wav");
    }

    public SourceEffect getSoundBye() {
        return soundBye = new SourceEffect("bye_bye.wav");
    }

    public SourceEffect getSoundTouch() {
        return soundTouch = new SourceEffect("touch.wav");
    }

    public SourceEffect getSoundStart() {
        return soundStart = new SourceEffect("start.wav");
    }

    public SourceEffect getSoundSetBomb() {
        return soundSetBomb = new SourceEffect("set_boom.wav");
    }

    public SourceEffect getSoundBomBang() {
        return soundBomBang = new SourceEffect("bomb_bang.wav");
    }

    public SourceEffect getSoundMonster() {
        return soundMonster = new SourceEffect("monster_die.wav");
    }

    public SourceEffect getSoundItem() {
        return soundItem = new SourceEffect("item.wav");
    }

    public SourceEffect getSoundBomberDie() {
        return soundBomberDie = new SourceEffect("bomber_die1.wav");
    }


    public SourceEffect getSoundBackground() {
        return soundBackground;
    }

}
