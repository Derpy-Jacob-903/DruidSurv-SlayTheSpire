package druidsurv.cards.colorless;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class FlameBarrierChoice extends AbstractEasyCard {
    public final static String ID = makeID("FlameBarrierChoice");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public FlameBarrierChoice() {
        super(ID, 0, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS, "Wolf_CardArt");

        if (AbstractDungeon.player != null && AbstractDungeon.player.hasPower("Accuracy")) {
            this.baseDamage = 4 + (AbstractDungeon.player.getPower("Accuracy")).amount;
        }
        else {
            this.baseDamage = 4;
        }
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}