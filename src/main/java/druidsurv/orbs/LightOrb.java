package druidsurv.orbs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.LightningOrbEvokeAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.SunShieldPower;

import java.util.Objects;

import static com.megacrit.cardcrawl.helpers.ImageMaster.loadImage;
import static druidsurv.ModFile.makeImagePath;
import static druidsurv.util.TexLoader.getTexture;

public class LightOrb extends AbstractOrb {
    private static final String[] DESCRIPTION = new String[] {
            "Passive: Whenever you are attacked, deal #b",
            " damage to the attacker. Stacks between Light orbs. NL Evoke: Deal #b",
            " Damage to a random enemy, once for each orb Channeled."
    };
    int baseEvokeAmount;
    int basePassiveAmount;

    public LightOrb() {
        this.ID = "druidsurv:Light";
        this.img = getTexture(makeImagePath("orbs/LightOrb.png"));
        this.baseEvokeAmount = 6;
        this.evokeAmount = this.baseEvokeAmount;
        this.basePassiveAmount = 6;
        this.passiveAmount = this.basePassiveAmount;
        applyFocus();
        updateDescription();
        this.channelAnimTimer = 0.5F;
    }

    public void updateDescription() {
        applyFocus();
        this.description = DESCRIPTION[0] + this.passiveAmount + DESCRIPTION[1] + this.evokeAmount + DESCRIPTION[2];
    }

    @Override
    public void onEvoke() {
        for (int i = 0; i < AbstractDungeon.player.orbs.size(); i++) {
            if (!Objects.equals(AbstractDungeon.player.orbs.get(i).ID, "Empty")) {
                AbstractDungeon.actionManager.addToTop(
                    new LightningOrbEvokeAction(
                        new DamageInfo((AbstractCreature) AbstractDungeon.player, this.evokeAmount, DamageInfo.DamageType.THORNS), false
                    )
                );
            }
        }
    }

    @Override
    public void onEndOfTurn() {
        applyFocus();
        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.actionManager.addToTop(
                (AbstractGameAction) new ApplyPowerAction(
                        p, p, (AbstractPower) new SunShieldPower(p, this.passiveAmount), this.passiveAmount, true, AbstractGameAction.AttackEffect.NONE
                )
        );
        this.description = DESCRIPTION[0] + this.passiveAmount + DESCRIPTION[1] + this.evokeAmount + DESCRIPTION[2];
    }

    @Override
    public AbstractOrb makeCopy() {
        return new LightOrb();
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
