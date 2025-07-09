package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class EnhancedReflexes extends AbstractEasyCard {
    public final static String ID = makeID("EnhancedReflexes");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public EnhancedReflexes() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, "EnhancedReflexes");
        baseDamage = 10;
        baseMagicNumber = magicNumber = 10;
        exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.HEROIC);
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        atb(new DrawCardAction(1));
    }

    @Override
    public void upp() {
        upgradeDamage(5);
    }
}