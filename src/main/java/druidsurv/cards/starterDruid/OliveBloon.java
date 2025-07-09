package druidsurv.cards.starterDruid;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class OliveBloon extends AbstractEasyCard {
    public final static String ID = makeID("OliveBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public OliveBloon() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, "Olive");
        baseDamage = 0;
        baseBlock = 5;
        tags.add(CardTags.STARTER_DEFEND);
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        //PersistFields.setBaseValue(this, 2);
        //ExhaustiveVariable.setBaseValue(this, 2);
        //MultiCardPreview.add(this, new DefendColorless());
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        //if (damage > 0)
        //{
            //addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new onedelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
            //addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 1, damage, "Olive Bloon"), 1, true, AbstractGameAction.AttackEffect.NONE));
        //}
        if (this.costForTurn < 1){ blck(); }
        else { bloonBlck(); }

        //if (ExhaustiveField.ExhaustiveFields.exhaustive.get(this) == 1)
        //{
            //atb(new MakeTempCardInDiscardAction(new DefendColorless(), 1));
        //}
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}