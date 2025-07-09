package druidsurv.orbs.mox;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
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
import java.util.UUID;

import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;
import static druidsurv.util.Wiz.att;
import static druidsurv.util.Wiz.p;

public class TapMox extends AbstractOrb{
    public UUID uuid;
    private static final String[] DESCRIPTION = new String[] {
            "Passive: Gain #b",
            ""
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
            strBuilder.append("[GRB]");
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
    public TapMox(int greenMox, int rubyMox, int blueMox, int voidMox, int colorlessMox, int gayMox) {
        this.ID = "druidsurv:MoxOrbTap";
        this.img = getTexture(makeImagePath("orbs/mox1_tapland.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        this.VoidAmount = voidMox;
        this.RandAmount = colorlessMox;
        this.RainAmount = gayMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
        this.uuid = UUID.randomUUID();
    }

    public TapMox(int greenMox, int rubyMox, int blueMox, int voidMox) {
        this.ID = "druidsurv:MoxOrbTap";
        this.img = getTexture(makeImagePath("orbs/mox1_tapland.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        this.VoidAmount = voidMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
        this.uuid = UUID.randomUUID();
    }

    public TapMox(int greenMox, int rubyMox, int blueMox ) {
        this.ID = "druidsurv:MoxOrbTap";
        this.img = getTexture(makeImagePath("orbs/mox1_tapland.png"));
        this.GreenAmount = greenMox;
        this.RubyAmount = rubyMox;
        this.BlueAmount = blueMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
        this.uuid = UUID.randomUUID();
    }


    @Deprecated
    public TapMox(int colorlessMox, int gayMox) {
        this.ID = "druidsurv:MoxOrbTap";
        this.img = getTexture(makeImagePath("orbs/mox1_tapland.png"));
        this.RandAmount = colorlessMox;
        this.RainAmount = gayMox;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
        this.uuid = UUID.randomUUID();
    }

    public TapMox() {
        this.ID = "druidsurv:MoxOrbTap";
        this.img = getTexture(makeImagePath("orbs/mox1_tapland.png"));
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
        this.uuid = UUID.randomUUID();
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
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof TapMox)
            {
                TapMox orb = (TapMox)p().orbs.get(i);
                if (orb.uuid == this.uuid)
                {
                    p().orbs.set(i, new MoxOrb(orb.GreenAmount, orb.RubyAmount, orb.BlueAmount, orb.VoidAmount));
                    p().orbs.get(i).setSlot(i, p().orbs.size());
                }
            }
        }
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

    }

    @Override
    public AbstractOrb makeCopy() {
        return new MoxOrb(GreenAmount, RubyAmount, BlueAmount, VoidAmount);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setColor(this.c);
        sb.draw(this.img, this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        //sb.draw(this.img2, this.cX - 48.0F - this.bobEffect.y / 8.0F, this.cY - 48.0F + this.bobEffect.y / 8.0F, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, 0.0F, 0, 0, 96, 96, false, false);
        renderText(sb);
        this.hb.render(sb);
    }

    @Override
    protected void renderText(SpriteBatch sb) {
        setBlueText();
        FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, this.blueText, this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET, this.c, this.fontScale);
    }

    @Override
    public void playChannelSFX() {
        // Sound effect logic here
    }
}
