package druidsurv.cards.powers;

import com.evacipated.cardcrawl.mod.stslib.variables.ExhaustiveVariable;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class SpikeStorm extends AbstractEasyCard {
    public final static String ID = makeID("SpikeStorm");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SpikeStorm() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY, "SpikeStorm_CardArt");
        baseDamage = 6;
        ExhaustiveVariable.setBaseValue(this, 2);
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        isMultiDamage = true;

        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        allDmg(AbstractGameAction.AttackEffect.FIRE);
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}