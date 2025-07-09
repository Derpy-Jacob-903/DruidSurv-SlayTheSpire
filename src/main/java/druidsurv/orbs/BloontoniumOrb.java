package druidsurv.orbs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.*;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.BloontoniumPower;

import java.util.ArrayList;

import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class BloontoniumOrb extends AbstractOrb {

    public static AbstractOrb getRandomOrbDruid(boolean useCardRng) {
        ArrayList<AbstractOrb> orbs = new ArrayList<>();
        orbs.add(new Lightning());
        orbs.add(new Frost());
        orbs.add(new LightOrb());
        orbs.add(new BloontoniumOrb());
        return useCardRng ? (AbstractOrb)orbs.get(AbstractDungeon.cardRandomRng.random(orbs.size() - 1)) : (AbstractOrb)orbs.get(MathUtils.random(orbs.size() - 1));
    }
    private static final String[] DESCRIPTION = new String[] {
            "Passive: Gain #b",
            " [druidsurv:BloontoniumIcon] NL Evoke: Gain #b",
            " [druidsurv:BloontoniumIcon]"
    };
    int baseEvokeAmount = 1;
    int basePassiveAmount = 1;

    enum towerSet {
        BLUE,
        GREEN,
        PURPLE,
        RED
    }

    public BloontoniumOrb() {
        this.ID = "druidsurv:BloontoniumOrb";
        this.img = getTexture(makeImagePath("orbs/RedBloontoniumOrb.png"));
        this.baseEvokeAmount = 1;
        this.evokeAmount = this.baseEvokeAmount;
        this.basePassiveAmount = 1;
        this.passiveAmount = this.basePassiveAmount;
        //applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public void updateDescription() {
        applyFocus();
        this.description = DESCRIPTION[0] + "1" + DESCRIPTION[1] + this.evokeAmount + DESCRIPTION[2];
    }

    @Override
    public void onEvoke() {
        //applyFocus();
        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.actionManager.addToTop(
            (AbstractGameAction) new ApplyPowerAction(
                p, p, (AbstractPower) new BloontoniumPower(p, this.evokeAmount), this.evokeAmount, true, AbstractGameAction.AttackEffect.NONE
            )
        );
    }

    @Override
    public void onEndOfTurn() {
        ///applyFocus();
        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.actionManager.addToTop(
                (AbstractGameAction) new ApplyPowerAction(
                        p, p, (AbstractPower) new BloontoniumPower(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE
                )
        );
        this.description = DESCRIPTION[0] + "1" + DESCRIPTION[1] + this.evokeAmount + DESCRIPTION[2];
    }

    @Override
    public AbstractOrb makeCopy() {
        return new BloontoniumOrb();
    }

    @Override
    public void render(SpriteBatch sb) {
        /* 102 */     sb.setColor(this.c);
        /* 103 */     sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, this.angle, 0, 0, 96, 96, false, false);

        /* 120 */     this.c.a /= 3.0F;
        /* 121 */     sb.setColor(this.shineColor);
        /* 122 */     sb.setBlendFunction(770, 1);
        /* 123 */     sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale * 1.2F, this.scale * 1.2F, this.angle / 1.2F, 0, 0, 96, 96, false, false);

        /* 140 */     sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale * 1.5F, this.scale * 1.5F, this.angle / 1.4F, 0, 0, 96, 96, false, false);
        /* 157 */     sb.setBlendFunction(770, 771);
        /* 158 */     renderText(sb);
        /* 159 */     this.hb.render(sb);
        /*     */   }

    @Override
    public void playChannelSFX() {
        // Sound effect logic here
    }
}
