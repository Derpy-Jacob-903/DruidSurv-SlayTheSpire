package druidsurv.orbs.mox;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.mod.stslib.actions.defect.EvokeSpecificOrbAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.random.Random;
import druidsurv.actions.EasyModalChoiceAction;
import druidsurv.cards.colorless.ModalChoiceMoxBlue;
import druidsurv.cards.colorless.ModalChoiceMoxGreen;
import druidsurv.cards.colorless.ModalChoiceMoxRuby;
import druidsurv.powers.mox.BlueMox;
import druidsurv.powers.mox.GreenMox;
import druidsurv.powers.mox.RubyMox;
import druidsurv.powers.mox.VoidMox;

import java.util.ArrayList;

import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;
import static druidsurv.util.Wiz.*;

public class MoxOrb extends AbstractOrb {
    private static final String[] DESCRIPTION = new String[] {

    };
    public int GreenAmount = 0;
    String GMoxText = "";
    public int RubyAmount = 0;
    String RMoxText = "";
    public int BlueAmount = 0;
    String BMoxText = "";
    public int RandAmount = 0;
    String CMoxText = "";
    public int RainAmount = 0;
    String QMoxText = "";
    public int VoidAmount = 0;
    String VMoxText = "";
    public String blueText = "";
    protected Texture img2;

    public void setBlueText() {
        //StringBuilder strBuilder = new StringBuilder("Passive: Gain");
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < GreenAmount; i++) {
            strBuilder.append("[G]");
            //strBuilder.append(" [druidsurv:GMoxIIcon]");
        }
        for (int i = 0; i < RubyAmount; i++) {
            strBuilder.append("[R]");
            //strBuilder.append(" [druidsurv:RMoxIIcon]");
        }
        for (int i = 0; i < BlueAmount; i++) {
            strBuilder.append("[B]");
            //strBuilder.append(" [druidsurv:BMoxIIcon]");
        }
        for (int i = 0; i < VoidAmount; i++) {
            strBuilder.append("[V]");
            //strBuilder.append(" [druidsurv:CMoxIIcon]");
        }
        for (int i = 0; i < RandAmount; i++) {
            strBuilder.append("[C]");
            //strBuilder.append(" [druidsurv:CMoxIIcon]");
        }
        for (int i = 0; i < RainAmount; i++) {
            strBuilder.append("[G][R][B]");
            //strBuilder.append(" [druidsurv:CMoxIIcon]");
        }
        blueText = strBuilder.toString();
    }

    enum towerSet {
        BLUE,
        GREEN,
        PURPLE,
        RED
    }

    @Deprecated
    public MoxOrb(int greenMox, int rubyMox, int blueMox, int voidMox, int colorlessMox, int gayMox) {
        this.ID = "druidsurv:MoxOrb";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        this.VoidAmount = voidMox;
        this.RandAmount = colorlessMox;
        this.RainAmount = gayMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public MoxOrb(int greenMox, int rubyMox, int blueMox, int voidMox) {
        this.ID = "druidsurv:MoxOrb";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        this.RainAmount = voidMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public MoxOrb(int greenMox, int rubyMox, int blueMox) {
        this.ID = "druidsurv:MoxOrb";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    @Deprecated
    public MoxOrb(int colorlessMox, int gayMox) {
        this.ID = "druidsurv:MoxOrb";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        this.RandAmount = colorlessMox;
        this.RainAmount = gayMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public MoxOrb() {
        this.ID = "druidsurv:MoxOrb";
        this.img = getTexture(makeImagePath("orbs/mox1.png"));
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public void updateDescription() {
        applyFocus();
        this.description = blueText;
    }

    public void onEvoke() {
    }

    @Override
    public void onStartOfTurn() {
        AbstractPlayer p = AbstractDungeon.player;
        /*
        if (0 < GreenAmount) {
            QApplyPowerAction(new GreenMox(p, GreenAmount));
        }
        if (0 < RubyAmount) {
            QApplyPowerAction(new RubyMox(p, RubyAmount));
        }
        if (0 < BlueAmount) {
            QApplyPowerAction(new BlueMox(p, BlueAmount));
        }
        if (0 < VoidAmount) {
            QApplyPowerAction(new VoidMox(p, VoidAmount));
        }
        if (0 < RandAmount) {
            Random rng = AbstractDungeon.cardRandomRng;
            for (int i = 0; i < RandAmount; i++) {
                int n = rng.random(0, 2);
                switch (n)
                {
                    case 0: QApplyPowerAction(new GreenMox(p, 1)); break;
                    case 1: QApplyPowerAction(new RubyMox(p, 1)); break;
                    case 2: QApplyPowerAction(new BlueMox(p, 1)); break;
                }
            }
        }
        if (0 < RainAmount) {
            ArrayList<AbstractCard> easyCardList = new ArrayList<>();
            easyCardList.add(new ModalChoiceMoxGreen());
            easyCardList.add(new ModalChoiceMoxRuby());
            easyCardList.add(new ModalChoiceMoxBlue());
            for (int i = 0; i < RainAmount; i++) {
                att(new EasyModalChoiceAction(easyCardList));
            }
        }
         */
    }

    @Override
    public void onEndOfTurn() {
        if (!(0 < GreenAmount + RubyAmount + BlueAmount + VoidAmount + RandAmount + RainAmount)) {
            att(new EvokeSpecificOrbAction(this));
        }
    }

    public void DiamondMoxAction(int amount) {
        AbstractPlayer p = AbstractDungeon.player;
        if (0 < amount) {
            Random rng = AbstractDungeon.cardRandomRng;
            for (int i = 0; i < amount; i++) {
                int n = rng.random(0, 2);
                switch (n)
                {
                    case 0: QApplyPowerAction(new GreenMox(p, 1)); break;
                    case 1: QApplyPowerAction(new RubyMox(p, 1)); break;
                    case 2: QApplyPowerAction(new BlueMox(p, 1)); break;
                }
            }
        }
    }
    public void PearlMoxAction(int amount) {
        AbstractPlayer p = AbstractDungeon.player;
        if (0 < amount) {
            ArrayList<AbstractCard> easyCardList = new ArrayList<>();
            easyCardList.add(new ModalChoiceMoxGreen());
            easyCardList.add(new ModalChoiceMoxRuby());
            easyCardList.add(new ModalChoiceMoxBlue());
            for (int i = 0; i < amount; i++) {
                att(new EasyModalChoiceAction(easyCardList));
            }
        }
    }
    public void QApplyPowerAction(AbstractPower abstractPower)
    {
        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.actionManager.addToTop(
            (AbstractGameAction) new ApplyPowerAction(
                p, p, abstractPower, abstractPower.amount, true, AbstractGameAction.AttackEffect.NONE
            )
        );
    }

    @Override
    public AbstractOrb makeCopy() {
        return new MoxOrb(GreenAmount, RubyAmount, BlueAmount, VoidAmount, RandAmount, RainAmount);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setColor(this.c);
        sb.draw(this.img, this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        if (0 < GreenAmount) {
            sb.draw(getTexture(makeImagePath("orbs/mox[G].png")), this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        }
        if (0 < RubyAmount) {
            sb.draw(getTexture(makeImagePath("orbs/mox[R].png")), this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        }
        if (0 < BlueAmount) {
            sb.draw(getTexture(makeImagePath("orbs/mox[B].png")), this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        }
        if (0 < VoidAmount) {
            sb.draw(getTexture(makeImagePath("orbs/mox[V].png")), this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        }
        if (0 < RandAmount) {
            sb.draw(getTexture(makeImagePath("orbs/mox[C].png")), this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        }
        if (0 < RainAmount) {
            sb.draw(getTexture(makeImagePath("orbs/mox[Q].png")), this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        }
        renderIcons(sb);
        renderText(sb);
        this.hb.render(sb);
    }

    public void renderIcons(SpriteBatch sb) {
        String[] icons = determineIcons(); // Method to decide which icons to render
        float[] offsets = calculateOffsets(icons.length); // Calculate offsets based on number of icons
        for (int i = 0; i < icons.length; i++) {
            sb.draw(
                    getTexture(makeImagePath(icons[i])),
                    this.cX - 48.0F - this.bobEffect.y / 8.0F + offsets[i],
                    this.cY - 48.0F + this.bobEffect.y / 8.0F,
                    48.0F,
                    48.0F,
                    96.0F,
                    96.0F,
                    this.scale,
                    this.scale,
                    0.0F,
                    0,
                    0,
                    96,
                    96,
                    false,
                    false
            );
        }
        renderText(sb);
        this.hb.render(sb);
    }

    // Determine which icons to render based on conditions
    private String[] determineIcons() {
        if (BlueAmount > 0 && RubyAmount > 0 && GreenAmount > 0) {
            return new String[]{"orbs/moxIcons/[B].png", "orbs/moxIcons/[R].png", "orbs/moxIcons/[G].png"};
        } else if (BlueAmount > 0 && RubyAmount > 0) {
            return new String[]{"orbs/moxIcons/[B].png", "orbs/moxIcons/[R].png"};
        } else if (BlueAmount > 0 && GreenAmount > 0) {
                return new String[]{"orbs/moxIcons/[R].png", "orbs/moxIcons/[G].png"};
        } else if (RubyAmount > 0 && GreenAmount > 0) {
            return new String[]{"orbs/moxIcons/[R].png", "orbs/moxIcons/[G].png"};
        } else if (BlueAmount > 0) {
            return new String[]{"orbs/moxIcons/[B].png"};
        } else if (RubyAmount > 0) {
            return new String[]{"orbs/moxIcons/[R].png"};
        } else if (GreenAmount > 0) {
            return new String[]{"orbs/moxIcons/[G].png"};
        }
        return new String[]{"orbs/moxIcons/[N].png"};
    }

    // Calculate offsets based on number of icons
    private float[] calculateOffsets(int count) {
        float[] offsets = new float[count];
        if (count == 1) {
            offsets[0] = 0;
        } else if (count == 2) {
            offsets[0] = 0;
            offsets[1] = -14;
        } else if (count == 3) {
            offsets[0] = 0;
            offsets[1] = -10;
            offsets[2] = -20;
        }
        return offsets;
    }

    enum  RenderMox
    {
        G,
        R,
        B,
        V
    }

    @Override
    protected void renderText(SpriteBatch sb) {
        setBlueText();

        //FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, this.blueText, this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET, this.c, this.fontScale);
    }

    @Override
    public void playChannelSFX() {
        // Sound effect logic here
    }
}
